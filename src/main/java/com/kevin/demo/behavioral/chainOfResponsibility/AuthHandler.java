package com.kevin.demo.behavioral.chainOfResponsibility;

/**
 * 认证处理器 - 责任链模式中的具体处理者角色(Concrete Handler)
 * <p>
 * 该处理器负责请求的认证检查，是责任链中的第一个环节
 * 如果请求为null，直接拒绝；否则传递给下一个处理器处理
 * 如果没有后续处理器，则认证通过
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public class AuthHandler extends Handler {

    /**
     * 处理认证请求
     * 实现具体的认证逻辑：
     * 1. 检查请求是否为null，如果是则拒绝处理
     * 2. 如果有后续处理器，将请求传递下去
     * 3. 如果没有后续处理器，说明认证通过
     * 
     * @param req 需要认证的请求对象
     */
    @Override
    public void process(String req) {
        if (req == null) {
            System.out.println(getClass().getSimpleName() + " process: 请求为空，认证失败");
        } else {
            if (getNextHandler() != null) {
                // 将请求传递给责任链中的下一个处理器
                getNextHandler().process(req);
            } else {
                // 没有后续处理器，认证通过
                System.out.println(getClass().getSimpleName() + " process: 认证通过");
            }
        }
    }
}
