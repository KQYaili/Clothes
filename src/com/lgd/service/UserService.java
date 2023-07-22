package com.lgd.service;

import com.lgd.bean.User;
import com.lgd.utils.BusinessException;

import java.nio.Buffer;

public interface UserService {
    public User register(User user)throws BusinessException;
    public User login(String username,String password) throws BusinessException;
}
