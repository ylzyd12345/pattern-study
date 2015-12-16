package com.kevin.demo.creational.原;

public class App {
	public static void main(String[] args) {
		Book book = new Book("haha","kevin",12.2);
		Book cloneBook = book.clone();
		System.out.println(book);
		System.out.println(cloneBook);
		
		Book deepCloneBook = book.deepClone();
		System.out.println(deepCloneBook);
		
	}
}
