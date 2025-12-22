package com.kevin.demo.structral.桥;

/**
 * 操作系统版本抽象类 - 桥接模式中的抽象化角色(Abstraction)
 * 定义操作系统播放视频的抽象接口，维护对VideoFile的引用
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public abstract class OperationSystemVersion {
    
    /**
     * 视频文件引用 - 桥接模式中的桥接对象
     */
    private VidioFile vidioFile;
    
    /**
     * 播放视频的抽象方法
     * @param fileName 视频文件名
     */
    abstract void play(String fileName);

    /**
     * 获取视频文件对象
     * @return VidioFile 视频文件对象
     */
    public VidioFile getVidioFile() {
        return vidioFile;
    }

    /**
     * 设置视频文件对象
     * @param vidioFile 视频文件对象
     */
    public void setVidioFile(VidioFile vidioFile) {
        this.vidioFile = vidioFile;
    }
}