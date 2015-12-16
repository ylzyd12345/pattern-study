package com.kevin.demo.creational.工and抽.简单工厂;

public class App {
	public static void main(String[] args) {
		Car car = CarFactory.createCar(CarTypeEnum.BMW);
		car.run();
		car = CarFactory.createCar(CarTypeEnum.BENZ);
		car.run();
	}
}
