package com.kevin.demo.structral.桥;

public abstract class OperationSystemVersion {
	
	private VidioFile vidioFile;
	
	abstract void play(String fileName);

	public VidioFile getVidioFile() {
		return vidioFile;
	}

	public void setVidioFile(VidioFile vidioFile) {
		this.vidioFile = vidioFile;
	}

	
	
	
}
