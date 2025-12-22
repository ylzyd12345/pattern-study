package com.kevin.demo.structural.facade;

/**
 * 等级服务类 - 外观模式中的子系统角色(SubSystem)
 * 提供用户等级的添加和删除功能
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class CmfLevel {
    public void addLevel() {
        System.out.println("add level");
    }
    
    public void delLevel() {
        System.out.println("del level");
    }
}
