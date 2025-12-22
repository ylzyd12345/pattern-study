package com.kevin.demo.behavioral.command;

/**
 * TVCloseCommand类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public class TVCloseCommand implements Command {

	private Televation tv;

	public TVCloseCommand(Televation tv) {
		this.tv = tv;
	}

	@Override
	public void execute() {
		this.tv.close();
	}

}
