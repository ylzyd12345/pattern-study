package com.kevin.demo.structral.组合;

public class VidioFile  extends File{

	public VidioFile(String name) {
		super(name);
	}

	@Override
	protected void display() {
		System.out.println("display vidioFile");
	}

}
