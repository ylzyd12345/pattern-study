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
    
    private CmfCommon common = new CmfCommon();
    
    private CmfLevel cmfLevel = new CmfLevel();
    
    private CmfPoint cmfPoint = new CmfPoint();
    
    public void register() {
        common.register();
        cmfLevel.addLevel();
        cmfPoint.addPoint();
    }
    
    public void unregiser() {
        common.unRegister();
        cmfLevel.delLevel();
        cmfPoint.delPoint();
    }
}
