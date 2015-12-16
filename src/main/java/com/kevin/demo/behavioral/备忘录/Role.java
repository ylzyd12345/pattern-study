package com.kevin.demo.behavioral.备忘录;

public class Role {
	private int bloodFlow;
	private int magicPoint;
	
	public int getBloodFlow() {
		return bloodFlow;
	}
	public void setBloodFlow(int bloodFlow) {
		this.bloodFlow = bloodFlow;
	}
	public int getMagicPoint() {
		return magicPoint;
	}
	public void setMagicPoint(int magicPoint) {
		this.magicPoint = magicPoint;
	}
	
	public void display() {
		System.out.println("当前血量："+ getBloodFlow() + "，当前魔法值：" + getMagicPoint());
	}
	
	public void hitBoss() {
		setBloodFlow(0);
		setMagicPoint(0);
		System.out.println("打boss时死了，血量为" + getBloodFlow() + "，魔法值为" + getMagicPoint());
		
	}
	
	public Memento saveMemento()
	{
		return new Memento(getBloodFlow(), getMagicPoint());
	}
	
	public void restoreMemento(Memento memento)
	{
		setBloodFlow(memento.getBloodFlow());
		setMagicPoint(memento.getMagicPoint());
	}
}
