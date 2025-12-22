package com.kevin.demo.structral.proxy;

/**
 * 游戏接口 - 代理模式中的抽象主题角色(Subject)
 * 定义真实主题和代理主题的共同接口
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public interface PlayGame {
    /**
     * 玩游戏
     * @param gameName 游戏名称
     */
    void play(String gameName);
}