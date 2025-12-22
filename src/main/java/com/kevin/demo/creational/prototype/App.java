package com.kevin.demo.creational.prototype;

/**
 * App类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
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
