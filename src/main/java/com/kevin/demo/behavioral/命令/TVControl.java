package com.kevin.demo.behavioral.命令;

public class TVControl {
	
	private Command command;
	
	public void action() {
		command.execute();
	}

	public void setCommand(Command command) {
		this.command = command;
	}
	
}
