package com.kevin.demo.creational.builder.badExample;

/**
 * MealBuilder抽象类 - 建造者模式中的抽象建造者角色
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
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

	/**
	 * Meal类 - 建造者模式中的产品角色
	 *
	 * @author Kevin
	 * @version 1.0
	 * @since 1.0.0
	 */
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

