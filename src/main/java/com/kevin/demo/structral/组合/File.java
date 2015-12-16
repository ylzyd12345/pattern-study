package com.kevin.demo.structral.组合;

public abstract class File {
	protected String name;

	public File(String name) {
		this.name = name;
	}

	protected abstract void display();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
