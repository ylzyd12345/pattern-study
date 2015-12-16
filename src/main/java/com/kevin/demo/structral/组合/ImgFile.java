package com.kevin.demo.structral.组合;

public class ImgFile  extends File{

	public ImgFile(String name) {
		super(name);
	}

	@Override
	protected void display() {
		System.out.println("display imgFile");
	}

}
