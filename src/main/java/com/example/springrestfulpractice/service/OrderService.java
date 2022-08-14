package com.example.springrestfulpractice.service;

import com.example.springrestfulpractice.controller.request.CreateOrderRequest;
import com.example.springrestfulpractice.controller.request.UpdateOrderRequest;
import com.example.springrestfulpractice.model.MealRepository;
import com.example.springrestfulpractice.model.OrderRepository;
import com.example.springrestfulpractice.model.mealEntity.Meal;
import com.example.springrestfulpractice.model.orderEntity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
     List<Order> orderList = new ArrayList<>();


     @Autowired
     private OrderRepository orderRepository;

     @Autowired
     private MealRepository mealRepository;




     public List<Meal> getAllMeals() {
         List<Meal> response= mealRepository.findAll();
         return response;
     }
     public List<Order> getAllOrders(){
         List<Order> response = orderRepository.findAll();
         return response;
     }

    public Order getOrder(int seq){
         Order order = this.orderRepository.findById(seq);

        return order;
    }



    public String createOrder(CreateOrderRequest request){
        Order order = new Order();

        order.setSeq(request.getSeq());
        order.setWaiter(request.getWaiter());
        order.setMeal_List(request.getMeal_List());
        order.setTotalPrice(getTotalPrice(order));


        orderRepository.save(order);

        return "OK";
    }

    public String updateOrder(int seq, UpdateOrderRequest request){
            Order updateOrder = this.orderRepository.findById(seq);
            updateOrder.setWaiter(request.getWaiter());
            updateOrder.setMeal_List(request.getMeal_List());
            updateOrder.setTotalPrice(getTotalPrice(updateOrder));


        orderRepository.save(updateOrder);
            return "updated";
    }
//
    public String deleteOrder(int seq){
        Order order = this.orderRepository.deleteById(seq);
        return "deleted";
    }


    public  int getTotalPrice(Order order) {
        int total = 0;
        List<Meal> meals = mealRepository.findAll();
        String mealList = order.getMeal_List();
        String[] s = mealList.split(" ");
        for(String i :s){
            for(Meal meal : meals){
                if(i.equals(meal.getName())){
                    total+=meal.getPrice();
                }
            }
        }

        return total;
    }

}
