package com.kevin.demo.structral.组合;

import java.util.ArrayList;

public class Folder  extends File{

	private ArrayList<File> files = new ArrayList<>();
	
	public Folder(String name) {
		super(name);
	}

	@Override
	protected void display() {
		for (File file : files) {
			file.display();
		}
	}
	
	public void addFile(File file) {
		files.add(file);
	}
	
	public void delFile(File file)
	{
		files.remove(file);
	}

}
