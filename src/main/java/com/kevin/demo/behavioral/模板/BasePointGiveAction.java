package com.kevin.demo.behavioral.模板;

public class BasePointGiveAction  extends AbstractPointGiveAction{

	@Override
	protected int dealGive(String user, int point) {
		return point;
	}

}
