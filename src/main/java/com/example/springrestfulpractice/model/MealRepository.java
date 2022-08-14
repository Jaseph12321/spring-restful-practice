package com.example.springrestfulpractice.model;

import com.example.springrestfulpractice.model.mealEntity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Integer> {

}
