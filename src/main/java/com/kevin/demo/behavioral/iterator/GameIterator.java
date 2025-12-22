package com.kevin.demo.behavioral.iterator;

public class GameIterator implements Iterator<Member>{

	private Member[] members;
	private int position;
	
	public GameIterator(Member[] members) {
		this.members = members;
	}

	@Override
	public boolean hasNext() {
		if (position > members.length -1 || null == members[position]) {
			return false;
		}
		return true;
	}

	@Override
	public Member next() {
		Member member = members[position];
		position ++ ;
		return member;
	}

}
