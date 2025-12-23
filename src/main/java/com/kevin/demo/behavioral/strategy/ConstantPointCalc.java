package com.kevin.demo.behavioral.strategy;

import java.math.BigDecimal;

/**
 * 常量积分计算类 - 策略模式中的具体策略角色(Concrete Strategy)
 * <p>
 * 该类实现了PointCalc接口，提供固定比例(1:1)的积分计算算法
 * 在策略模式中，这是最基础的积分计算策略，通常用作默认策略
 * 
 * @author Kevin
 * @since 1.0.0
 */
public class ConstantPointCalc implements PointCalc {

    /**
     * 按照固定比例(1:1)计算积分
     * <p>
     * 该方法实现了最简单的积分计算逻辑：1元对应1积分
     * 直接返回原始积分值，不进行任何额外的计算或调整
     * 
     * @param point 原始积分金额，不能为null
     * @return 计算后的积分值，与输入值相同
     * @throws IllegalArgumentException 如果输入参数为null
     */
    @Override
    public BigDecimal calc(BigDecimal point) {
        if (point == null) {
            throw new IllegalArgumentException("积分金额不能为空");
        }
        // 固定比例(1:1)计算，直接返回原始积分值
        return point.multiply(BigDecimal.ONE);
    }
}
