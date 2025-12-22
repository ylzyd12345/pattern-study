package com.kevin.demo.behavioral.command;

/**
 * TVOpenCommand类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
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
