package com.kevin.demo.behavioral.chainOfResponsibility;

/**
 * 处理者抽象类 - 责任链模式中的抽象处理者角色(Handler)
 * <p>
 * 责任链模式(Chain of Responsibility Pattern)：使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系
 * 将这些对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理它为止
 * <p>
 * 该类定义了处理请求的接口和维护后继处理者的方法，是责任链模式的核心
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public abstract class Handler {
    
    /**
     * 持有后继处理者的引用
     */
    private Handler nextHandler;

    /**
     * 获取下一个处理者
     * 
     * @return 后继处理者对象，如果没有则返回null
     */
    public Handler getNextHandler() {
        return nextHandler;
    }

    /**
     * 设置下一个处理者，构建责任链
     * 包含参数验证逻辑，确保责任链的有效性
     * 
     * @param nextHandler 下一个处理者对象，不能为null且不能与当前处理者类型相同
     * @throws IllegalArgumentException 当参数无效时抛出异常
     */
    public void setNextHandler(Handler nextHandler) {
        // 参数有效性检查
        if (nextHandler == null) {
            throw new IllegalArgumentException("Next handler cannot be null!");
        }
        // 防止循环引用
        if (this.getClass().equals(nextHandler.getClass())) {
            throw new IllegalArgumentException("Next handler must be different from current handler!");
        }
        this.nextHandler = nextHandler;
    }

    /**
     * 处理请求的抽象方法
     * 具体的处理逻辑由子类实现
     * 
     * @param req 需要处理的请求内容
     */
    public abstract void process(String req);
}
