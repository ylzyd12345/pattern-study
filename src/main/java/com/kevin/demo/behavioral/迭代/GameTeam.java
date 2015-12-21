package com.kevin.demo.behavioral.迭代;

public class GameTeam implements Team{

	private static final int MAX_MEMBERS = 5;
	private Member[] members = new Member[MAX_MEMBERS];
	int numberOfMembers  = 0;
	
	@Override
	public void add(Member member) {
		if (numberOfMembers>= MAX_MEMBERS) {
			System.out.println("队伍满了");
		}else {
			members[numberOfMembers] = member;
			numberOfMembers ++;
		}
	}


	@Override
	public Iterator<Member> iterator() {
		return new GameIterator(members);
	}

}
