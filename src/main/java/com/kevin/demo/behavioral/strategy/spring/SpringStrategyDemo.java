package com.kevin.demo.behavioral.strategy.spring;

import com.kevin.demo.behavioral.strategy.PointCalc;

import java.math.BigDecimal;

/**
 * 策略模式演示
 * <p>
 * 展示策略模式的使用
 * 
 * @author Kevin
 * @since 1.0.0
 */
public class SpringStrategyDemo {
    
    public static void main(String[] args) {
        // 创建积分服务实例
        SpringPointGiveServiceImpl pointService = new SpringPointGiveServiceImpl();
        
        System.out.println("=== 策略模式演示 ===");
        
        // 使用默认策略（基础积分策略）
        System.out.println("\n1. 使用默认策略（基础积分策略）：");
        pointService.givePoint(new BigDecimal("100"));
        
        // 切换到满减积分策略
        System.out.println("\n2. 切换到满减积分策略：");
        pointService.setPointCalc(new SpringFullGivePointCalc());
        pointService.givePoint(new BigDecimal("100"));
        
        // 切换回基础积分策略
        System.out.println("\n3. 切换回基础积分策略：");
        pointService.setPointCalc(new SpringPointCalc());
        pointService.givePoint(new BigDecimal("200"));
    }
}