package com.kevin.demo.structral.外观;

public class App {
	public static void main(String[] args) {
		CmfFacade cmfFacade = new CmfFacade();
		cmfFacade.register();
		cmfFacade.unregiser();
	}
}
