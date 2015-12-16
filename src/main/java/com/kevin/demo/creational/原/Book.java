package com.kevin.demo.creational.原;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Book implements Cloneable,Serializable {
	private static final long serialVersionUID = -2227190595410858190L;
	
	private String name;
	private String author;
	private double money;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public Book(String name, String author, double money) {
		this.name = name;
		this.author = author;
		this.money = money;
	}

	public Book(String name) {
		this.name = name;
	}

	@Override
	protected Book clone() {
		Book cloneBook = null;

		try {
			cloneBook = (Book) super.clone();
		} catch (CloneNotSupportedException e) {
		}
		return cloneBook;
	}
	
	public Book deepClone() {
		Book cloneBook = null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(this);
			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bis);
			cloneBook = (Book) ois.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cloneBook;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [name=");
		builder.append(name);
		builder.append(", author=");
		builder.append(author);
		builder.append(", money=");
		builder.append(money);
		builder.append("]");
		return builder.toString();
	}
	
	

}
