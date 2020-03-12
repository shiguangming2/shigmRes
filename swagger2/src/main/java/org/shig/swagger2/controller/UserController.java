package org.shig.swagger2.controller;

import io.swagger.annotations.*;
import org.shig.swagger2.bean.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shigm
 * @date 2019/11/29 22:02
 */
@RestController
@Api(tags = "用户接口数据")
public class UserController {

    @GetMapping("/user")
    @ApiOperation(value = "根据id获取数据",notes = "传递用户ID获取用户数据")
    @ApiImplicitParam(name = "id",value = "用户号",required = true)
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功响应"),
            @ApiResponse(code = 404,message = "失败响应")}
    )
    public User getUser( Integer id) {
        User user = new User();
        user.setId(2);
        user.setName("yangjie");
        return  user;
    }
}
