package com.lgd.test;

import com.lgd.bean.Clothes;
import com.lgd.utils.ProductsXmlUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ProductsXmlUtilsTest {
    @Test
    public void test(){
        List<Clothes> clothes = ProductsXmlUtils.parserProductFromXml();
        System.out.println(Arrays.toString(clothes.toArray()));
    }
}
