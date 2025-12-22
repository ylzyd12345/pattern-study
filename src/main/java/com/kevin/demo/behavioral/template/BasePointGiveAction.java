package com.kevin.demo.behavioral.template;

/**
 * BasePointGiveAction类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public class BasePointGiveAction  extends AbstractPointGiveAction{

	@Override
	protected int dealGive(String user, int point) {
		return point;
	}

}
