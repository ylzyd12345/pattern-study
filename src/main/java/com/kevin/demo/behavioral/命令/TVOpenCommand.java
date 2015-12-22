package com.kevin.demo.behavioral.命令;

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
