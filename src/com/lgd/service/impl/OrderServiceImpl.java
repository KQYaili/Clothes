package com.lgd.service.impl;

import com.lgd.bean.Order;
import com.lgd.service.OrderService;
import com.lgd.utils.BusinessException;
import com.lgd.utils.OrderIO;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderIO orderIO=new OrderIO();
    @Override
    public void buyProduct(Order o) throws BusinessException {
        orderIO.add(o);
    }

    @Override
    public List<Order> list() throws BusinessException {
        return orderIO.list();
    }

    @Override
    public Order findById(int orderId) throws BusinessException {
        return orderIO.findByOrderId(orderId);
    }
}
