package com.smec;

import com.smec.service.User;
import com.smec.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Main {

    @SuppressWarnings("resource")
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserService userService = context.getBean(UserService.class);
        userService.setusers();
        User user = userService.login("bob@example.com", "password");
        // System.out.println(user.getName());
        // User user1 = userService.register("1990205@qq.com", "bilibiliGanBI", "牛铁日铁牛");
        // System.out.println(user1.getName() + " has registered.");
        User user1 = userService.login("1990205@qq.com", "bilibiliGanBI");
    }
}