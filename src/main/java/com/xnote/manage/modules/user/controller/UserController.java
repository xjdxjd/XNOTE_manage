package com.xnote.manage.modules.user.controller;

import com.xnote.manage.modules.user.bean.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @DESC:   用户操作控制器
 * @ClassName: UserController
 */
@RestController
@RequestMapping("/user")
public class UserController {
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    static {
        User user = new User();
        user.setAge(18);
        user.setId(1L);
        user.setName("aa");
        users.put(1L, user);
    }

    @GetMapping("/getUser/{id}")
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    public User getUser(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id){

        return users.get(id);
    }
}
