package com.kevin.demo.behavioral.责任链;

/**
 * @author Administrator
 *
 */
public class App {
	public static void main(String[] args) {
		Handler authHandler = new AuthHandler();
		Handler aliasHandler = new AliasHandler();
		Handler printHandler = new PrintHandler();
		authHandler.setNextHandler(aliasHandler);
		aliasHandler.setNextHandler(printHandler);
		authHandler.process(null);
		
		authHandler.process("alias");
		
		authHandler.process("haha");
	}
}
