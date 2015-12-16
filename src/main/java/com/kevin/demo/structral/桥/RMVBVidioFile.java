package com.kevin.demo.structral.桥;

public class RMVBVidioFile  implements VidioFile{

	@Override
	public void decode(String fileName, String osType) {
		System.out.println(fileName+".mvb play in " + osType);
	}

}
