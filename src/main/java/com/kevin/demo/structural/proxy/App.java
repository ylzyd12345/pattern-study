package com.kevin.demo.structural.proxy;

/**
 * 代理模式演示类
 * 用于展示如何使用代理模式控制对真实主题的访问
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class App {
    public static void main(String[] args) {
        // 创建婴儿游戏对象
        PlayGame babyGame = new BabyPlayGame();
        
        // 使用代理包装婴儿游戏对象
        PlayGame proxy = new PlayGameProxy(babyGame);
        
        // 玩适合婴儿的游戏（允许）
        proxy.play("小蝌蚪找妈妈");
        
        // 玩不适合婴儿的游戏（被拦截）
        proxy.play("yellowGame");
    }
}
