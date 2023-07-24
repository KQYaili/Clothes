package com.lgd.service;

import com.lgd.bean.Order;
import com.lgd.utils.BusinessException;

import java.util.List;

public interface OrderService {
    public void buyProduct(Order o)throws BusinessException;
    public List<Order>list()throws BusinessException;
    public Order findById(int orderId)throws BusinessException;
}
