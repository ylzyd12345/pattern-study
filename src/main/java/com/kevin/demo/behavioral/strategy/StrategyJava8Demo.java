package com.kevin.demo.behavioral.策略;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * 策略模式Java 8+特性演示
 * <p>
 * 展示如何使用Java 8的Lambda表达式、函数式接口和Stream API来实现和增强策略模式
 * 
 * @author Kevin
 */
public class StrategyJava8Demo {

    public static void main(String[] args) {
        // 创建积分服务
        PointGiveServiceImpl pointService = new PointGiveServiceImpl(point -> point); // 使用默认策略
        BigDecimal originalPoint = new BigDecimal("100");
        
        // 1. 使用Lambda表达式直接传递策略（无需创建新类）
        System.out.println("=== 使用Lambda表达式的策略模式 ===");
        
        // 基本积分策略
        pointService.setPointCalc(point -> point);
        pointService.givePoint(originalPoint);
        
        // 双倍积分策略
        pointService.setPointCalc(point -> point.multiply(new BigDecimal("2")));
        pointService.givePoint(originalPoint);
        
        // 满100送50积分策略
        pointService.setPointCalc(point -> {
            if (point.compareTo(new BigDecimal("100")) >= 0) {
                return point.add(new BigDecimal("50"));
            }
            return point;
        });
        pointService.givePoint(originalPoint);
        
        // 2. 使用Function接口（Java 8内置的函数式接口）替代自定义接口
        System.out.println("\n=== 使用Function接口的策略模式 ===");
        
        // 使用Map存储多种策略
        Map<String, Function<BigDecimal, BigDecimal>> pointStrategies = new HashMap<>();
        
        // 注册不同的策略
        pointStrategies.put("base", p -> p);
        pointStrategies.put("double", p -> p.multiply(new BigDecimal("2")));
        pointStrategies.put("vip", p -> p.multiply(new BigDecimal("1.5")));
        pointStrategies.put("promotion", p -> {
            BigDecimal result = p;
            if (p.compareTo(new BigDecimal("200")) >= 0) {
                result = result.add(new BigDecimal("100"));
            }
            return result;
        });
        
        // 动态选择并应用策略
        String[] selectedStrategies = {"base", "double", "vip", "promotion"};
        for (String strategyName : selectedStrategies) {
            Function<BigDecimal, BigDecimal> strategy = pointStrategies.get(strategyName);
            System.out.println(strategyName + " 策略: " + strategy.apply(originalPoint));
        }
        
        // 3. 组合策略
        System.out.println("\n=== 组合策略示例 ===");
        
        // 先应用双倍积分，再应用促销策略
        Function<BigDecimal, BigDecimal> doubleThenPromotion = 
                pointStrategies.get("double").andThen(pointStrategies.get("promotion"));
        
        System.out.println("双倍 + 促销策略: " + doubleThenPromotion.apply(originalPoint));
    }
}