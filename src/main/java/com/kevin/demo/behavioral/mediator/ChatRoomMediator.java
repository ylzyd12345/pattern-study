package com.kevin.demo.behavioral.mediator;

/**
 * 聊天室中介者接口
 * <p>
 * 中介者模式中的中介者角色(Mediator)，定义了同事对象之间交互的接口
 * 
 * @author Kevin
 */
public interface ChatRoomMediator {
    void sendMessage(String message, String userId);
    
    void registerUser(User user);
}
