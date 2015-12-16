package com.kevin.demo.structral.外观;

public class CmfFacade{
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
