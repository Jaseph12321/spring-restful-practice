package com.example.springrestfulpractice.controller.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderRequest {
    private int seq;
    private int totalPrice;
    private String waiter;
    private String meal_List;

}

