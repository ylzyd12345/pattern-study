package com.kevin.demo.creational.builder.badExample;

import com.kevin.demo.creational.builder.badExample.MealBuilder.Meal;

public class KFCDirector {
	private MealBuilder mealBuilder;

	public KFCDirector(MealBuilder mealBuilder) {
		this.mealBuilder = mealBuilder;
	}
	
	public Meal constuct()
	{
		mealBuilder.builderDrink();
		mealBuilder.builderFood();
		return mealBuilder.getMeal();
	}
	
	
}
