package com.example.springrestfulpractice.controller;

import com.example.springrestfulpractice.controller.request.CreateOrderRequest;
import com.example.springrestfulpractice.controller.request.UpdateOrderRequest;
import com.example.springrestfulpractice.controller.response.StatusResponse;
import com.example.springrestfulpractice.model.mealEntity.Meal;
import com.example.springrestfulpractice.model.orderEntity.Order;
import com.example.springrestfulpractice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/menu")
    public List<Meal> getAllMeals() {
        List<Meal> mealList = this.orderService.getAllMeals();
        return mealList;
    }

    @GetMapping
    public List<Order> getAllOrders(){
        List<Order> orderList = this.orderService.getAllOrders();
        return orderList;
    }

    @GetMapping("/{seq}")
    public Order getOrderById(@PathVariable int seq){
        Order getOrder = this.orderService.getOrder(seq);
        return getOrder;
    }

    @PostMapping()
    public StatusResponse createOrder(@RequestBody CreateOrderRequest order) {
        String createdOrder = this.orderService.createOrder(order);
        return new StatusResponse(createdOrder);
    }

    @PutMapping("/{seq}")
    public StatusResponse updateOrder(@PathVariable int seq, @RequestBody UpdateOrderRequest order){
        String updatedOrder = this.orderService.updateOrder(seq,order);
        return new StatusResponse(updatedOrder);
    }

    @DeleteMapping("/{seq}")
    public StatusResponse deleteOrder(@PathVariable int seq){
        String deletedOrder = this.orderService.deleteOrder(seq);
        return new StatusResponse(deletedOrder);
    }
}
