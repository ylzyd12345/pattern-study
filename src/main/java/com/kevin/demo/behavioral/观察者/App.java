package com.kevin.demo.behavioral.观察者;

/**
 * @author Administrator
 *
 */
public class App {
	public static void main(String[] args) {
		WeatherStation weatherStation = new WeatherStation();
		WeatherApp weatherApp = new WeatherApp();
		WeatherSite weatherSite = new WeatherSite();
		weatherStation.addObserver(weatherApp);
		weatherStation.addObserver(weatherSite);
		weatherStation.changed();
	}
}
