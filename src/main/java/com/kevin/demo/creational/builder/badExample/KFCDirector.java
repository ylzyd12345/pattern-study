package com.kevin.demo.creational.builder.badExample;

import com.kevin.demo.creational.builder.badExample.MealBuilder.Meal;

/**
 * KFCDirector类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
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
