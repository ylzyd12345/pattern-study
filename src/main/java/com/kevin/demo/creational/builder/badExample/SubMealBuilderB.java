package com.kevin.demo.creational.builder.badExample;

/**
 * SubMealBuilderB类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public class SubMealBuilderB extends MealBuilder {

	public SubMealBuilderB(Meal meal) {
		super(meal);
	}

	@Override
	public void builderDrink() {
		System.out.println("a drink is ok, ");

	}

	@Override
	public void builderFood() {
		System.out.println("a food is ok.");
	}


}
