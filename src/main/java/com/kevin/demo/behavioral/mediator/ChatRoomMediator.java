package com.kevin.demo.behavioral.中介;

/**
 * 聊天室中介者接口
 * <p>
 * 中介者模式中的中介者角色(Mediator)，定义了同事对象之间交互的接口
 * 
 * @author Kevin
 */
public interface ChatRoomMediator {
    /**
     * 发送消息
     * 
     * @param message 消息内容
     * @param userId 发送者ID
     */
    void sendMessage(String message, String userId);
    
    /**
     * 注册用户
     * 
     * @param user 用户对象
     */
    void registerUser(User user);
}