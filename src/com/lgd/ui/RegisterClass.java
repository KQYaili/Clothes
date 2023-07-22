package com.lgd.ui;

import com.lgd.bean.User;
import com.lgd.service.UserService;
import com.lgd.service.impl.UserServiceImpl;
import com.lgd.utils.BusinessException;

public class RegisterClass extends BaseClass{
    public void register() throws BusinessException {
            println(getString("input.username"));
            String username=input.nextLine();
            println(getString("input.password"));
            String password=input.nextLine();
            User user = new User(username,password);
            UserService userService = new UserServiceImpl();
            userService.register(user);
    }
}
