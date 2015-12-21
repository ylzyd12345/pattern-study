package com.kevin.demo.behavioral.模板;

/**
 * @author Administrator
 *
 */
public class App {
	public static void main(String[] args) {
		AbstractPointGiveAction hk = new HKPointGiveAction();
		hk.give("hk110", 9);
		hk.give("120", 2);
		
		AbstractPointGiveAction base = new BasePointGiveAction();
		base.give("hk110", 9);
		base.give("120", 2);
	}
}
