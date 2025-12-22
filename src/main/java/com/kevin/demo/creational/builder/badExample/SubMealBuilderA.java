package com.kevin.demo.creational.builder.badExample;

/**
 * SubMealBuilderA类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public class SubMealBuilderA extends MealBuilder {

	public SubMealBuilderA(Meal meal) {
		super(meal);
	}

	@Override
	public void builderDrink() {
		System.out.println("b drink is ok, ");

	}

	@Override
	public void builderFood() {
		System.out.println("b food is ok.");
	}


}
