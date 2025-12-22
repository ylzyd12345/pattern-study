package com.kevin.demo.structural.facade;

/**
 * 外观模式演示类 - 外观模式中的客户端角色(Client)
 * 演示如何通过外观类简化子系统的使用
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class App {
    public static void main(String[] args) {
        // 创建外观对象
        CmfFacade cmfFacade = new CmfFacade();
        
        // 通过外观对象调用注册功能（内部会调用多个子系统）
        cmfFacade.register();
        
        System.out.println("--------分割线--------");
        
        // 通过外观对象调用注销功能（内部会调用多个子系统）
        cmfFacade.unregiser();
    }
}
