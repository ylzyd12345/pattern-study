package com.kevin.demo.creational.建.好的例子;

import com.kevin.demo.creational.建.好的例子.Person.PersonBuilder;

public class App {
	public static void main(String[] args){
		PersonBuilder personBuilder = new PersonBuilder("kevin");
		System.out.println(personBuilder.build());
		
		personBuilder.withColor(ColorTypeEnum.BLACK).withClothes(ClothesTypeEnum.NICE);
		System.out.println(personBuilder.build());
		
	}
}
