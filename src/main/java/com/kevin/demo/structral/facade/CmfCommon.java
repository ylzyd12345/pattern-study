package com.kevin.demo.structral.facade;

/**
 * 公共服务类 - 外观模式中的子系统角色(SubSystem)
 * 提供用户注册和注销的基本功能
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class CmfCommon {
    /**
     * 用户注册
     */
    public void register() {
        System.out.println("add user");
    }
    
    /**
     * 用户注销
     */
    public void unRegister() {
        System.out.println("del user");
    }
}