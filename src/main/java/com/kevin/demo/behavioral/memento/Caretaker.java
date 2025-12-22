package com.kevin.demo.behavioral.memento;

/**
 * Caretaker类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public class Caretaker {
	private Memento memento;

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
	
}
