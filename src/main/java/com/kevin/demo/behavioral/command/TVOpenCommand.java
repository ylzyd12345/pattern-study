package com.kevin.demo.behavioral.command;

public class TVOpenCommand implements Command {

	private Televation tv;

	public TVOpenCommand(Televation tv) {
		this.tv = tv;
	}

	@Override
	public void execute() {
		this.tv.open();
	}

}
