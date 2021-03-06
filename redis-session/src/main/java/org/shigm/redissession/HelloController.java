package org.shigm.redissession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class HelloController {
    @Value("${server.port}")
    Integer port;

    @GetMapping("/set")
    public   String set(HttpSession session){
        session.setAttribute("name", "shigm");
        return String.valueOf(port);
    }

    @GetMapping("/get")
    public  String get(HttpSession session){
        String name = (String)session.getAttribute("name");
        return String.valueOf(port)+":"+name;
    }


}
