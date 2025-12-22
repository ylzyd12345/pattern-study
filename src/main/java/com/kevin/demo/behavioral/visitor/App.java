package com.kevin.demo.behavioral.访问者;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class App {
	public static void main(String[] args) {
		Person police  = new Police();
		Chimney woodChimney = new WoodChimney();
		Casement woodCasement = new WoodCasement();
		Door woodDoor = new WoodDoor();
		
		Chimney steelChimney = new SteelChimney();
		Casement steelCasement = new SteelCasement();
		Door steelDoor = new SteelDoor();
		
		List<Door> doors = new ArrayList<Door>();
		doors.add(woodDoor);
		doors.add(steelDoor);
		
		List<Chimney> chimneys = new ArrayList<Chimney>();
		chimneys.add(woodChimney);
		chimneys.add(steelChimney);
		
		List<Casement> casements = new ArrayList<Casement>();
		casements.add(woodCasement);
		casements.add(steelCasement);
		
		for (Casement casement : casements) {
			casement.accept(police);
		}
		
		for (Chimney chimney : chimneys) {
			chimney.accept(police);
		}
		
		for (Door door : doors) {
			door.accept(police);
		}
		
		
	}
}
