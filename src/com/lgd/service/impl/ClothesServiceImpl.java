package com.lgd.service.impl;

import com.lgd.bean.Clothes;
import com.lgd.service.ClothesService;
import com.lgd.utils.BusinessException;
import com.lgd.utils.ClothesIO;
import com.lgd.utils.ProductsXmlUtils;

import java.util.List;

public class ClothesServiceImpl implements ClothesService {
    private ClothesIO clothesIO=new ClothesIO();
    @Override
    public List<Clothes> list() throws BusinessException {
        return clothesIO.list();
    }

    @Override
    public Clothes findByID(String cid) throws BusinessException {
        return clothesIO.findById(cid);
    }
    public void update()throws BusinessException{
        clothesIO.update();
    }
}
