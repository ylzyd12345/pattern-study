package com.kevin.demo.structural.proxy;

/**
 * 游戏代理类 - 代理模式中的代理主题角色(Proxy)
 * 实现抽象主题接口，持有真实主题的引用，并控制对真实主题的访问
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class PlayGameProxy implements PlayGame {
    
    private PlayGame playGame;
    
    public PlayGameProxy(PlayGame playGame) {
        this.playGame = playGame;
    }

    @Override
    public void play(String gameName) {
        // 代理逻辑：过滤不适合婴儿玩的游戏
        if (playGame instanceof BabyPlayGame) {
            if ("yellowGame".equalsIgnoreCase(gameName)) {
                System.err.println("no no no, u can't play this game!");
                return;
            }
        }
        
        // 调用真实主题的方法
        playGame.play(gameName);
    }
}
