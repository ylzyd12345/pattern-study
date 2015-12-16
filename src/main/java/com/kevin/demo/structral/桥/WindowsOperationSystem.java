package com.kevin.demo.structral.桥;

public class WindowsOperationSystem extends OperationSystemVersion {

	@Override
	void play(String fileName) {
		getVidioFile().decode(fileName, "windows");
	}

}
