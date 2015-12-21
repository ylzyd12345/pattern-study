package com.kevin.demo.behavioral.模板;

public abstract class AbstractPointGiveAction {
	public boolean give(String user,int point) {
		if (!isAuthed(user)) {
			return false;
		}
		if (!isRiskCheckPass(user)) {
			return false;
		}
		if (!isLineLimitPass(point)) {
			return false;
		}
		int realpoint = dealGive(user , point);
		log(user, realpoint);
		return true;
	}

	abstract protected int dealGive(String user, int point);

	private void log(String user, int point) {
		System.out.println("user " + user +" add " + point + " points!");
	}

	protected boolean isLineLimitPass(int point){
		// default pass
		return true;
	}

	protected boolean isRiskCheckPass(String user) {
		// default pass
		return true;
	}

	protected boolean isAuthed(String user) {
		// default pass
		return true;
	}
	
	
	
}
