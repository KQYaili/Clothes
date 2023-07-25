package com.lgd.ui;

import com.lgd.bean.User;
import com.lgd.service.UserService;
import com.lgd.service.impl.UserServiceImpl;
import com.lgd.utils.BusinessException;

public class RegisterClass extends BaseClass{
    private UserService userService;
    public RegisterClass(){
        userService= (UserService) beanFactory.getBean("userService");
    }
    public void register() throws BusinessException {
            println(getString("input.username"));
            String username=input.nextLine();
            println(getString("input.password"));
            String password=input.nextLine();
            User user = new User(username,password);
            userService.register(user);
    }
}
