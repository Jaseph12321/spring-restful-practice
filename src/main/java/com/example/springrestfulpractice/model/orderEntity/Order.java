package com.example.springrestfulpractice.model.orderEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

// 使用 Lombok 加入 Getter, Setter, Constructor
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
@SecondaryTable(name="meals")
public class Order {
    @Id
    @Column(table="orders")
    private int seq;
    @Column(table="orders")
    private int totalPrice;
    @Column(table="orders")
    private String waiter;
    @Column(table="orders")
    private String meal_List;






    
}


