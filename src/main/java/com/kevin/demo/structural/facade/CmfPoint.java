package com.kevin.demo.structural.facade;

/**
 * 积分服务类 - 外观模式中的子系统角色(SubSystem)
 * 提供用户积分的添加和删除功能
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class CmfPoint {
    public void addPoint() {
        System.out.println("add point");
    }
    
    public void delPoint() {
        System.out.println("del point");
    }
}
