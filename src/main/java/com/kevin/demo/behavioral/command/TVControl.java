package com.kevin.demo.behavioral.command;

/**
 * TVControl类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public class TVControl {
	
	private Command command;
	
	public void action() {
		command.execute();
	}

	public void setCommand(Command command) {
		this.command = command;
	}
	
}
