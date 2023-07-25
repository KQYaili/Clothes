package com.lgd.ui;

import com.lgd.bean.User;
import com.lgd.service.UserService;
import com.lgd.service.impl.UserServiceImpl;
import com.lgd.utils.BusinessException;

public class LoginClass extends BaseClass{
    private UserService userService;
    public LoginClass(){
        userService= (UserService) beanFactory.getBean("userService");
    }
    public void login()throws BusinessException{
        println(getString("input.username"));
        String username=input.nextLine();
        println(getString("input.password"));
        String password=input.nextLine();
        User user = userService.login(username, password);
        if(user!=null){
            currUser=user;
        }else{
            throw new BusinessException("login.error");
        }
    }
}
