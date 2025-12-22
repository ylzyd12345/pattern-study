package com.kevin.demo.behavioral.迭代;

/**
 * @author Administrator
 *
 */
public class App {
	public static void main(String[] args) {
		Team gameTeam = new GameTeam();
		gameTeam.add(new Member("haha"));
		gameTeam.add(new Member("heihei"));
		gameTeam.add(new Member("hoho"));
		gameTeam.add(new Member("gaga"));
		gameTeam.add(new Member("gege"));
		gameTeam.add(new Member("xixi"));
		Iterator<Member> gameIterator = gameTeam.iterator();
		while (gameIterator.hasNext()) {
			System.out.println(gameIterator.next().getName());
		}
	}
}
