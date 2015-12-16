package com.kevin.demo.behavioral.观察者;

import java.util.Observable;

public class WeatherStation extends Observable{
	public void changed() {
		setChanged();
		notifyObservers("hot");
	}
}
