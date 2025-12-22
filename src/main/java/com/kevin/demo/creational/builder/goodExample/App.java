package com.kevin.demo.creational.builder.goodExample;

import com.kevin.demo.creational.builder.goodExample.Person.PersonBuilder;

public class App {
	public static void main(String[] args){
		PersonBuilder personBuilder = new PersonBuilder("kevin");
		System.out.println(personBuilder.build());
		
		personBuilder.withColor(ColorTypeEnum.BLACK).withClothes(ClothesTypeEnum.NICE);
		System.out.println(personBuilder.build());
		
	}
}
