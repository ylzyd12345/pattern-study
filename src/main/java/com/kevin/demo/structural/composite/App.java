package com.kevin.demo.structural.composite;

/**
 * 组合模式演示类 - 组合模式中的客户端角色(Client)
 * 演示如何使用组合模式创建和管理文件系统结构
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class App {
    
    /**
     * 主方法，演示组合模式的使用
     * 
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 创建一个文件夹
        Folder folder = new Folder("C:");
        
        // 创建图片文件和视频文件
        VidioFile vidioFile = new VidioFile("vidio a.avi");
        ImgFile imgFile = new ImgFile("img a.jpg");
        
        // 向文件夹中添加文件
        folder.addFile(imgFile);
        folder.addFile(vidioFile);
        
        // 显示文件夹内容
        folder.display();
        
        System.out.println("\n--------分割线--------\n");
        
        // 直接显示单个文件
        System.out.println("直接显示单个文件:");
        vidioFile.display();
        imgFile.display();
        
        System.out.println("\n--------分割线--------\n");
        
        // 从文件夹中删除文件
        System.out.println("删除视频文件后:");
        folder.delFile(vidioFile);
        folder.display();
    }
}
