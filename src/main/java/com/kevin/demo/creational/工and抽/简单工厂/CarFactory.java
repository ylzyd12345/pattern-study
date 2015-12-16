package com.kevin.demo.creational.工and抽.简单工厂;

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
