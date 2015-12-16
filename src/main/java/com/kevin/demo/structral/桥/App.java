package com.kevin.demo.structral.桥;

public class App {
	public static void main(String[] args) {
		OperationSystemVersion osv = new WindowsOperationSystem();
		VidioFile aviVidioFile = new AVIVidioFile();
		VidioFile rmvbVidioFile = new RMVBVidioFile();
		osv.setVidioFile(aviVidioFile);
		osv.play("你好中国");
		
		//osv = new LinuxOperationSystem();
		osv.setVidioFile(rmvbVidioFile);
		osv.play("你好中国");
		
		osv = new LinuxOperationSystem();
		osv.setVidioFile(rmvbVidioFile);
		osv.play("拜拜中国");
	}
}
