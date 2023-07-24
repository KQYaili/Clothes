package com.lgd.service;

import com.lgd.bean.Clothes;
import com.lgd.utils.BusinessException;

import java.util.List;

public interface ClothesService {
    public List<Clothes>list()throws BusinessException;
    public Clothes findByID(String cid)throws BusinessException;
}
