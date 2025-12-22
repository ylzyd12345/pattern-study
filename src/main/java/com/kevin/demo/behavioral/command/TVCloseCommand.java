package com.kevin.demo.behavioral.命令;

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
