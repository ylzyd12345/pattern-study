package com.kevin.demo.creational.builder.badExample;

import com.kevin.demo.creational.builder.badExample.MealBuilder.Meal;

public class App {
	public static void main(String[] args) {
		MealBuilder mealBuilder = new SubMealBuilderA(new Meal("meal a"));
		KFCDirector kfcDirector = new KFCDirector(mealBuilder);
		kfcDirector.constuct();
		
		mealBuilder = new SubMealBuilderB(new Meal("meal b"));
		kfcDirector = new KFCDirector(mealBuilder);
		kfcDirector.constuct();
	}
}
