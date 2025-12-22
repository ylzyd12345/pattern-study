package com.kevin.demo.creational.factory.简单factory;

/**
 * CarFactory类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public class CarFactory {
	public static Car createCar(CarTypeEnum carType)
	{
		if(CarTypeEnum.BMW == carType)
		{
			return new BMWCar();
		}else if(CarTypeEnum.BENZ == carType)
		{
			return new BENZCar();
		}else
		{
			return null;
		}
	}
	
}
