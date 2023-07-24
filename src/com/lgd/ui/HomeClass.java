package com.lgd.ui;

import com.lgd.bean.Clothes;
import com.lgd.bean.Order;
import com.lgd.bean.OrderItem;
import com.lgd.service.ClothesService;
import com.lgd.service.OrderService;
import com.lgd.service.impl.ClothesServiceImpl;
import com.lgd.service.impl.OrderServiceImpl;
import com.lgd.utils.BusinessException;
import com.lgd.utils.ConsoleTable;
import com.lgd.utils.DateUtils;

import java.util.Date;
import java.util.List;

public class HomeClass extends BaseClass{
    private OrderService orderService=new OrderServiceImpl();
    private ClothesService clothesService=new ClothesServiceImpl();
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
                    try {
                        BuyProducts();
                        flag=false;
                    }catch (BusinessException e){
                        println(e.getMessage());
                    }
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

    private void BuyProducts() throws BusinessException {
        //生成订单
        boolean flag=true;
        int count=1;
        float sum=0.0f;
        Order order=new Order();
        while (flag){
            println(getString("product.input.id"));
            String id=input.nextLine();
            println(getString("product.input.shoppingNum"));
            String shoppingNum=input.nextLine();
            OrderItem orderItem=new OrderItem();
            Clothes clothes = clothesService.findByID(id);
            int num=Integer.parseInt(shoppingNum);
            if(num>clothes.getNum()){
                throw new BusinessException("product.num.error");
            }
            clothes.setNum(clothes.getNum()-num);//减库存
            orderItem.setClothes(clothes);
            orderItem.setShoppingNum(num);
            orderItem.setSum(clothes.getPrice()*num);
            sum+=orderItem.getSum();
            orderItem.setItemId(count++);
            order.getOrderItemList().add(orderItem);
            String isBuy = input.nextLine();
            switch (isBuy){
                case "1":
                    flag=true;
                    break;
                case "2":
                    flag=false;
                    break;
                default:
                    break;
            }
        }
        order.setCreateDate(DateUtils.toDate(new Date()));
        order.setUserId(currUser.getId());
        order.setSum(sum);
        order.setOrderId(orderService.list().size()+1);
        orderService.buyProduct(order);
        clothesService.update();
        showProducts();
    }

    private void findOrderById() {
    }

    private void findList() {
    }

    private void showProducts(){
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
