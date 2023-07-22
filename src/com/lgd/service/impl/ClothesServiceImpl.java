package com.lgd.service.impl;

import com.lgd.bean.Clothes;
import com.lgd.service.ClothesService;
import com.lgd.utils.BusinessException;
import com.lgd.utils.ProductsXmlUtils;

import java.util.List;

public class ClothesServiceImpl implements ClothesService {

    @Override
    public List<Clothes> list() throws BusinessException {
        List<Clothes> clothes = ProductsXmlUtils.parserProductFromXml();
        return clothes;
    }
}
