package com.kevin.demo.behavioral.template;

public class BasePointGiveAction  extends AbstractPointGiveAction{

	@Override
	protected int dealGive(String user, int point) {
		return point;
	}

}
