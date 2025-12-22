package com.kevin.demo.structural.bridge;

/**
 * AVI视频文件实现类 - 桥接模式中的具体实现化角色(ConcreteImplementor)
 * 实现AVI格式视频的解码功能
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class AVIVidioFile implements VidioFile {

    @Override
    public void decode(String fileName, String osType) {
        System.out.println(fileName + ".avi play in " + osType);
    }
}
