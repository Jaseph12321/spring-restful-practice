package com.example.springrestfulpractice.model.mealEntity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "meals")
public class Meal {


    @Id
    @Column(table="meals")
    private String name;
    @Column(table="meals")
    private int price;
    @Column(table="meals")
    private String description;


}
