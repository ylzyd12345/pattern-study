package com.kevin.demo.creational.建造者.不好的例子;

import com.kevin.demo.creational.建造者.不好的例子.MealBuilder.Meal;

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
