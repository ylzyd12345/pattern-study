package com.kevin.demo.behavioral.观察者;

import java.util.Observable;
import java.util.Observer;

public class WeatherSite implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherStation) {
			listenning((String)arg);
		}
	}
	
	private void listenning(String weather)
	{
		System.out.println("WeatherSite recieve weather changed msg!, weather is " + weather);;
	}

}
