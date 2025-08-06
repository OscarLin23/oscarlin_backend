package com.example.oscarlin.controller;

import com.example.oscarlin.common.Result;
import com.example.oscarlin.domain.User;
import com.example.oscarlin.service.UserService;
import com.example.oscarlin.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;
    @GetMapping("/selectALL")
    public Result selectALL(User user){
        List<User> users = userService.selectAll(user);
        return Result.success(users);
    }
    @PostMapping("/login")
    @ResponseBody
    public Result login(@RequestBody User user){
        User users=userService.login(user);
        if (users!=null){
            //设置token发往前端口
            users.setToken(JWTUtils.createToken(users));
            System.out.println("后端生成的token为：\n"+users.getToken());
            return Result.success(users);
        }else return Result.error("用户名或密码错误");
    }
    @GetMapping("/checkToken")
    public Boolean checkToken(HttpServletRequest request){
        String token=request.getHeader("token");
        return JWTUtils.checkToken(token);
    }
    @PostMapping("/user/register")
    public Result register(@RequestParam String username, @RequestParam String password){
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        User user1=userService.register(user);
        if (user1!=null){
            return Result.success(user1);
        }else{
            return Result.error("注册失败");
        }
    }
}
