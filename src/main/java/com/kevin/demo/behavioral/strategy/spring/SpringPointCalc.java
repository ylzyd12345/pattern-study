package com.kevin.demo.behavioral.strategy.spring;

import com.kevin.demo.behavioral.strategy.PointCalc;

import java.math.BigDecimal;

/**
 * 基础积分计算策略
 * <p>
 * 策略模式(Strategy Pattern)示例实现
 * 
 * @author Kevin
 * @since 1.0.0
 */
public class SpringPointCalc implements PointCalc {
    
    @Override
    public BigDecimal calc(BigDecimal point) {
        System.out.println("使用Spring基础积分计算策略");
        return point;
    }
}
