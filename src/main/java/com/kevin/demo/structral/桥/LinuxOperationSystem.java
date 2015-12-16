package com.kevin.demo.structral.桥;

public class LinuxOperationSystem extends OperationSystemVersion {

	@Override
	void play(String fileName) {
		getVidioFile().decode(fileName, "linux");
	}

}
