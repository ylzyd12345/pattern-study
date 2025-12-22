package com.kevin.demo.behavioral.策略.spring;

import com.kevin.demo.behavioral.策略.PointCalc;

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
    
    /**
     * 计算积分
     * <p>
     * 基础积分策略：直接返回原始积分值
     * 
     * @param point 原始积分值
     * @return 计算后的积分值
     */
    @Override
    public BigDecimal calc(BigDecimal point) {
        System.out.println("使用Spring基础积分计算策略");
        return point;
    }
}