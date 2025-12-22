package com.kevin.demo.behavioral.strategy.spring;

import com.kevin.demo.behavioral.strategy.PointCalc;
import com.kevin.demo.behavioral.strategy.PointGiveService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 积分服务实现
 * <p>
 * 策略模式(Strategy Pattern)示例实现
 * <p>
 * 模拟Spring的依赖注入特性，实现动态选择不同的积分计算策略
 * 
 * @author Kevin
 * @since 1.0.0
 */
public class SpringPointGiveServiceImpl implements PointGiveService {
    
    private PointCalc pointCalc;
    
    private Map<String, PointCalc> pointCalcMap;
    
    public SpringPointGiveServiceImpl() {
        // 初始化策略映射，模拟Spring容器的Bean管理
        this.pointCalcMap = new HashMap<>();
        this.pointCalcMap.put("springPointCalc", new SpringPointCalc());
        this.pointCalcMap.put("springFullGivePointCalc", new SpringFullGivePointCalc());
        
        // 设置默认策略
        this.pointCalc = pointCalcMap.get("springPointCalc");
    }
    
    @Override
    public void givePoint(BigDecimal point) {
        BigDecimal result = pointCalc.calc(point);
        System.out.println("使用Spring策略模式计算积分：" + result);
    }
    
    public void setPointCalcStrategy(String strategyName) {
        if (pointCalcMap.containsKey(strategyName)) {
            this.pointCalc = pointCalcMap.get(strategyName);
            System.out.println("切换积分计算策略为：" + strategyName);
        } else {
            throw new IllegalArgumentException("无效的策略名称：" + strategyName);
        }
    }
    
    @Override
    public void setPointCalc(PointCalc pointCalc) {
        this.pointCalc = pointCalc;
    }
}
