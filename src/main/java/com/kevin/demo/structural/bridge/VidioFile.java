package com.kevin.demo.structural.bridge;

/**
 * 视频文件接口 - 桥接模式中的实现化角色(Implementor)
 * 定义视频文件的解码操作，将其与具体的操作系统实现分离
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public interface VidioFile {
    /**
     * 解码视频文件
     * @param fileName 视频文件名
     * @param osType 操作系统类型
     */
    void decode(String fileName, String osType);
}
