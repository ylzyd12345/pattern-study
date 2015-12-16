package com.kevin.demo.structral.桥;

public class AVIVidioFile implements VidioFile{

	@Override
	public void decode(String fileName, String osType) {
		System.out.println(fileName+".avi play in " + osType);
	}

}
