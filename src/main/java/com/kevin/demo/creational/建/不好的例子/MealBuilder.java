package com.kevin.demo.creational.建.不好的例子;

public abstract class MealBuilder {
	private Meal meal;
	
	public MealBuilder(Meal meal) {
		this.meal = meal;
	}

	protected abstract void builderDrink();

	protected abstract void builderFood();

	public Meal getMeal() {
		return meal;
	}

	static class Meal {
		private String name;

		public Meal(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}
}
