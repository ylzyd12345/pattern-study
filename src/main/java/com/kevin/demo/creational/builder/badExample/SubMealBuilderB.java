package com.kevin.demo.creational.builder.badExample;

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
