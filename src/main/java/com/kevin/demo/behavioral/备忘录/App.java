package com.kevin.demo.behavioral.备忘录;

/**
 * @author Administrator
 *
 */
public class App {
	public static void main(String[] args) {
		Role role = new Role();
		role.setBloodFlow(100);
		role.setMagicPoint(100);
		System.out.println("大战boss前：");
		role.display();
		Caretaker caretaker = new Caretaker();
		caretaker.setMemento(role.saveMemento());
		System.out.println("大战boss，开始存档：");
		role.hitBoss();
		System.out.println("大战boss后，死了：");
		role.display();
		System.out.println("恢复存档，复活：");
		role.restoreMemento(caretaker.getMemento());
		role.display();
	}
}
