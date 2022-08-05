package com.example.springrestfulpractice.service;

import com.example.springrestfulpractice.model.Meal;
import com.example.springrestfulpractice.model.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
     List<Order> orderList = new ArrayList<>();

     public OrderService(){
         List<Meal> meal = new ArrayList<>();
         meal.add(new Meal("candy",100,"sweet~~"));
         meal.add(new Meal("cookie",200,"cracky~~"));
         this.orderList.add(new Order(1,300,"Jaseph",meal));

         List<Meal> meal2 = new ArrayList<>();
         meal2.add(new Meal("hamburger",200,"yum~~"));
         meal2.add(new Meal("rice",300,"bright~~"));


         this.orderList.add(new Order(2,500,"Ivy",meal2));

     }

     public List<Order> getAllOrders(){return this.orderList;}

    public Order getOrder(int seq){
         for(Order order:this.orderList){
             if(seq == order.getSeq()){
                 return order;
             }
         }

        return null;
    }

    public Order getOrderbyId(int seq){
         for(Order order: this.orderList){
             if(seq == order.getSeq()){
                 return order;
             }
         }
         return null;
    }

    public Order createOrder(Order order){
        this.orderList.add(order);
        return order;
    }

    public Order updateOrder(int seq, Order order){
          for(Order updateOrder: this.orderList){
              if(seq == updateOrder.getSeq()){
                  updateOrder.setTotalPrice(order.getTotalPrice());
                  updateOrder.setWaiter(order.getWaiter());
                  updateOrder.setMealList(order.getMealList());
                  return updateOrder;
              }
          }
            return null;
    }

    public Order deleteOrder(int seq){
        for(Order deleteOrder: this.orderList){
            if(seq== deleteOrder.getSeq()){
                this.orderList.remove(deleteOrder);
                return deleteOrder;
            }
        }
        return null;
    }
}
