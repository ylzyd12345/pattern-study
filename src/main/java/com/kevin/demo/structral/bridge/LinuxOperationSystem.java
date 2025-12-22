package com.kevin.demo.structral.bridge;

/**
 * Linux操作系统实现类 - 桥接模式中的扩展抽象化角色(RefinedAbstraction)
 * 实现Linux平台下的视频播放功能
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class LinuxOperationSystem extends OperationSystemVersion {

    @Override
    void play(String fileName) {
        getVidioFile().decode(fileName, "Linux");
    }
}