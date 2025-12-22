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
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 发型类型
	 */
	private HearTypeEnum hearType;
	
	/**
	 * 肤色类型
	 */
	private ColorTypeEnum colorType;
	
	/**
	 * 服装类型
	 */
	private ClothesTypeEnum clothesType;
	
	/**
	 * 私有构造方法，只能通过建造者类创建实例
	 * @param personBuilder 建造者实例
	 */
	private Person(PersonBuilder personBuilder) {
		this.name = personBuilder.name;
		this.hearType = personBuilder.hearType;
		this.colorType = personBuilder.colorType;
		this.clothesType = personBuilder.clothesType;
	}
	
	

	/**
	 * 重写toString方法，返回人员信息字符串
	 * @return 人员信息字符串
	 */
	@Override
	public String toString() {
		return "Person [name=" + name + ", hearType=" + hearType + ", colorType=" + colorType + ", clothesType="
				+ clothesType + "]";
	}



	/**
	 * 人员建造者类
	 * 用于构建Person对象，提供链式调用接口
	 */
	public static class PersonBuilder {
		
		/**
		 * 姓名
		 */
		private String name;
		
		/**
		 * 发型类型
		 */
		private HearTypeEnum hearType;
		
		/**
		 * 肤色类型
		 */
		private ColorTypeEnum colorType;
		
		/**
		 * 服装类型
		 */
		private ClothesTypeEnum clothesType;
		
		
		/**
		 * 建造者构造方法
		 * @param name 人员姓名（必填）
		 */
		public PersonBuilder(String name) {
			this.name = name;
		}

		/**
		 * 设置发型类型
		 * @param hearType 发型类型枚举
		 * @return 建造者实例，用于链式调用
		 */
		public PersonBuilder withHear(HearTypeEnum hearType)
		{
			this.hearType = hearType;
			return this;
		}
		
		/**
		 * 设置肤色类型
		 * @param colorType 肤色类型枚举
		 * @return 建造者实例，用于链式调用
		 */
		public PersonBuilder withColor(ColorTypeEnum colorType)
		{
			this.colorType = colorType;
			return this;
		}
		
		/**
		 * 设置服装类型
		 * @param clothesType 服装类型枚举
		 * @return 建造者实例，用于链式调用
		 */
		public PersonBuilder withClothes(ClothesTypeEnum clothesType)
		{
			this.clothesType = clothesType;
			return this;
		}
		
		/**
		 * 构建Person对象
		 * @return 构建完成的Person实例
		 */
		public Person build(){
			return new Person(this);
		}
	}
	
}