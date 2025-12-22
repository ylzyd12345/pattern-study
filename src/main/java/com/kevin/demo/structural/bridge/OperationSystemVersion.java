package com.kevin.demo.structural.bridge;
/**
 * @author Administrator
 *
 */
public abstract class OperationSystemVersion {
    /**
     * 播放视频文件
     * @param fileName 视频文件名
     */
    private VidioFile vidioFile;
    
    abstract void play(String fileName);

    public VidioFile getVidioFile() {
        return vidioFile;
    }

    public void setVidioFile(VidioFile vidioFile) {
        this.vidioFile = vidioFile;
    }
}
