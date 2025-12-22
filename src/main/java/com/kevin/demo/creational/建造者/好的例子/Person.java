package com.kevin.demo.creational.建造者.好的例子;

public class Person {
	private String name;
	
	private HearTypeEnum hearType;
	
	private ColorTypeEnum colorType;
	
	private ClothesTypeEnum clothesType;
	
	private Person(PersonBuilder personBuilder) {
		this.name = personBuilder.name;
		this.hearType = personBuilder.hearType;
		this.colorType = personBuilder.colorType;
		this.clothesType = personBuilder.clothesType;
	}
	
	

	@Override
	public String toString() {
		return "Person [name=" + name + ", hearType=" + hearType + ", colorType=" + colorType + ", clothesType="
				+ clothesType + "]";
	}



	public static class PersonBuilder {
		
		private String name;
		
		private HearTypeEnum hearType;
		
		private ColorTypeEnum colorType;
		
		private ClothesTypeEnum clothesType;
		
		
		public PersonBuilder(String name) {
			this.name = name;
		}

		public PersonBuilder withHear(HearTypeEnum hearType)
		{
			this.hearType = hearType;
			return this;
		}
		
		public PersonBuilder withColor(ColorTypeEnum colorType)
		{
			this.colorType = colorType;
			return this;
		}
		
		public PersonBuilder withClothes(ClothesTypeEnum clothesType)
		{
			this.clothesType = clothesType;
			return this;
		}
		
		public Person build(){
			return new Person(this);
		}
	}
	
}
