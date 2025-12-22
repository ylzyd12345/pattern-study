package com.kevin.demo.structural.facade;

/**
 * CMF外观类 - 外观模式中的外观角色(Facade)
 * 为子系统中的一组接口提供一个统一的入口点
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class CmfFacade {
    
    /**
     * 公共服务子系统
     */
    private CmfCommon common = new CmfCommon();
    
    /**
     * 等级服务子系统
     */
    private CmfLevel cmfLevel = new CmfLevel();
    
    /**
     * 积分服务子系统
     */
    private CmfPoint cmfPoint = new CmfPoint();
    
    /**
     * 用户注册（组合调用子系统的方法）
     */
    public void register() {
        common.register();
        cmfLevel.addLevel();
        cmfPoint.addPoint();
    }
    
    /**
     * 用户注销（组合调用子系统的方法）
     */
    public void unregiser() {
        common.unRegister();
        cmfLevel.delLevel();
        cmfPoint.delPoint();
    }
}
