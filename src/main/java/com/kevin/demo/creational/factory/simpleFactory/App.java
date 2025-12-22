package com.kevin.demo.creational.factory.简单factory;

public class App {
	public static void main(String[] args) {
		Car car = CarFactory.createCar(CarTypeEnum.BMW);
		car.run();
		car = CarFactory.createCar(CarTypeEnum.BENZ);
		car.run();
	}
}
