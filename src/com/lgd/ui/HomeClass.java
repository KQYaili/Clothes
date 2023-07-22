package com.lgd.ui;

import com.lgd.bean.Clothes;
import com.lgd.service.ClothesService;
import com.lgd.service.impl.ClothesServiceImpl;
import com.lgd.utils.ConsoleTable;

import java.util.List;

public class HomeClass extends BaseClass{
    public void show(){
        showProducts();
        println("welcome"+currUser.getUsername());
        boolean flag=true;
        while(flag){
            println(getString("home.function"));
            println(getString("info.select"));
            String select=input.nextLine();
            switch (select){
                case "1"://查找全部订单
                    findList();
                    flag=false;
                    break;
                case "2"://查找订单
                    findOrderById();
                    flag=false;
                    break;
                case "3"://购买
                    BuyProducts();
                    flag=false;
                    break;
                case "0"://退出

                    flag=false;
                    System.exit(0);
                    break;
                default:
                    println(getString("input.error"));
                    break;
            }
        }
    }

    private void BuyProducts() {
    }

    private void findOrderById() {
    }

    private void findList() {
    }

    private void showProducts(){
        ClothesService clothesService =new ClothesServiceImpl();
        List<Clothes> list = clothesService.list();
        ConsoleTable t = new ConsoleTable(8, true);
        t.appendRow();
        t.appendColumn("id")
                .appendColumn("brand")
                .appendColumn("style")
                .appendColumn("color")
                .appendColumn("size")
                .appendColumn("num")
                .appendColumn("price")
                .appendColumn("description");
        for(Clothes c:list){
            t.appendRow();
            t.appendColumn(c.getId())
                    .appendColumn(c.getBrand())
                    .appendColumn(c.getStyle())
                    .appendColumn(c.getColor())
                    .appendColumn(c.getSize())
                    .appendColumn(c.getNum())
                    .appendColumn(c.getPrice())
                    .appendColumn(c.getDescription());
        }
        println(t.toString());
    }
}
