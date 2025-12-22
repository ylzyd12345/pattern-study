package com.kevin.demo.structural.proxy;

/**
 * 婴儿游戏类 - 代理模式中的真实主题角色(RealSubject)
 * 实现抽象主题接口，定义真实的业务逻辑
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class BabyPlayGame implements PlayGame {

    @Override
    public void play(String gameName) {
        System.out.println("ok, u can play game:" + gameName);
    }
}
