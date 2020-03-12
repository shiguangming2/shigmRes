package org.shigm.fileupload;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class FileUploadController {
    SimpleDateFormat format = new SimpleDateFormat("/yyyy/MM/dd");
    @PostMapping("/upload")
    public  String fileuoload(MultipartFile file, HttpServletRequest req){
        String oldname = file.getOriginalFilename();
        String realPath=req.getServletContext().getRealPath("/img")+format.format(new Date());
        String newname=UUID.randomUUID().toString()+oldname.substring(oldname.lastIndexOf("."));
        File folder = new File(realPath);
        if(!folder.exists()){
            folder.mkdirs();
        }
        try {
            file.transferTo(new File(folder,newname));
        }catch (Exception e){
            e.printStackTrace();
            return  "error";
        }
        String url= req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+"/img"+format.format(new Date())+"/"+newname;

        return  url;

    }
}
