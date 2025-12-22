package com.kevin.demo.structural.bridge;

/**
 * 桥接模式演示类
 * 用于展示如何使用桥接模式实现操作系统与视频文件格式的解耦
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class App {
    public static void main(String[] args) {
        // 创建视频文件对象
        VidioFile rmvb = new RMVBVidioFile();
        VidioFile avi = new AVIVidioFile();
        
        // 创建Windows操作系统并播放不同格式视频
        OperationSystemVersion windows = new WindowsOperationSystem();
        windows.setVidioFile(rmvb);
        windows.play("变形金刚");
        
        windows.setVidioFile(avi);
        windows.play("变形金刚");
        
        // 创建Linux操作系统并播放不同格式视频
        OperationSystemVersion linux = new LinuxOperationSystem();
        linux.setVidioFile(rmvb);
        linux.play("变形金刚");
        
        linux.setVidioFile(avi);
        linux.play("变形金刚");
    }
}
