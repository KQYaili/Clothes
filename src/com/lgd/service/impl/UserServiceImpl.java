package com.lgd.service.impl;

import com.lgd.bean.User;
import com.lgd.service.UserService;
import com.lgd.utils.BusinessException;
import com.lgd.utils.EmptyUtils;
import com.lgd.utils.UserIO;

public class UserServiceImpl implements UserService {

    @Override
    public User register(User user) throws BusinessException {
        UserIO userIO = new UserIO();
        userIO.add(user);
        userIO.writeUsers();
        return user;
    }

    @Override
    public User login(String username, String password) throws BusinessException {
        if(EmptyUtils.isEmpty(username)){
            throw new BusinessException("username.notnull");
        }
        if(EmptyUtils.isEmpty(password)){
            throw new BusinessException("password.notnull");
        }
        UserIO userIO = new UserIO();
        User user = userIO.findByUsernameAndPassword(username, password);
        return user;
    }
}
