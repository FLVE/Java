package me.iwjf.controller;

import me.iwjf.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @ResponseBody
    @GetMapping("/user")
    public List<User> getAllUser(){
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i);
            user.setName("iwjf");
            user.setAddress("www");
            user.setDate(new Date());
            users.add(user);
        }
        return users;
    }
}
