package com.kevin.demo.creational.builder.goodExample;

/**
 * 人员类 - 建造者模式中的产品角色(Product)
 * <p>
 * 建造者模式(Builder Pattern)：将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示
 * <p>
 * 本示例展示了建造者模式的良好实践，通过内部静态建造者类实现链式调用，提高代码可读性和可维护性
 * 
 * @author Kevin
 * @since 1.0.0
 */
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

	/**
	 * PersonBuilder类 - 建造者模式中的建造者角色(Builder)
	 */
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