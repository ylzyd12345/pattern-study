package com.kevin.demo.structral.组合;

/**
 * @author Administrator
 *
 */
public class App {
	public static void main(String[] args) {
		Folder folder = new Folder("C:");
		VidioFile vidioFile = new VidioFile("vidio a");
		ImgFile imgFile = new ImgFile("img a");
		folder.addFile(imgFile);
		folder.addFile(vidioFile);
		folder.display();
		
		vidioFile.display();
		imgFile.display();
		
		folder.delFile(vidioFile);
		folder.display();
		
	}
}
