package com.kevin.demo.behavioral.command;

public class TVControl {
	
	private Command command;
	
	public void action() {
		command.execute();
	}

	public void setCommand(Command command) {
		this.command = command;
	}
	
}
