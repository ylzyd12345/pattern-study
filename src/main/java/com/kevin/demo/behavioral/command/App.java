package com.kevin.demo.behavioral.命令;

/**
 * @author Administrator
 *
 */
public class App {
	public static void main(String[] args) {
		
		Televation televation = new Televation();
		Command openCommand = new TVOpenCommand(televation);
		TVControl tvControl = new TVControl();
		tvControl.setCommand(openCommand);
		tvControl.action();
		
		tvControl.setCommand(new TVCloseCommand(televation));
		tvControl.action();
		
	}
}
