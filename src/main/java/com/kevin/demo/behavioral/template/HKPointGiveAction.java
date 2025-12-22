package com.kevin.demo.behavioral.template;

/**
 * HKPointGiveAction类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public class HKPointGiveAction  extends AbstractPointGiveAction{

	@Override
	protected int dealGive(String user, int point) {
		return point * 4;
	}

	@Override
	protected boolean isAuthed(String user) {
		if (!user.startsWith("hk")) {
			System.out.println("user is not hk, can't give point!");
			return false;
		}
		return true;
	}
	
	

}
