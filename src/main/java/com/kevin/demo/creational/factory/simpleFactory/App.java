package com.kevin.demo.creational.factory.简单factory;

/**
 * App类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public class App {
	public static void main(String[] args) {
		Car car = CarFactory.createCar(CarTypeEnum.BMW);
		car.run();
		car = CarFactory.createCar(CarTypeEnum.BENZ);
		car.run();
	}
}
