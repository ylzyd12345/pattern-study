package com.kevin.demo.behavioral.mediator;

/**
 * 用户类
 * <p>
 * 中介者模式中的同事角色(Colleague)，定义了同事对象的行为，通过中介者与其他同事对象交互
 * 
 * @author Kevin
 */
public class User {
    
    private String id;
    private String name;
    private ChatRoomMediator mediator;
    
    /**
     * 构造方法
     * 
     * @param id 用户ID
     * @param name 用户名
     */
    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    /**
     * 发送消息
     * 
     * @param message 消息内容
     */
    public void sendMessage(String message) {
        System.out.println(name + "发送消息: " + message);
        mediator.sendMessage(message, id);
    }
    
    /**
     * 接收消息
     * 
     * @param message 消息内容
     * @param senderName 发送者名称
     */
    public void receiveMessage(String message, String senderName) {
        System.out.println(name + "收到来自" + senderName + "的消息: " + message);
    }
    
    // getter and setter methods
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public ChatRoomMediator getMediator() {
        return mediator;
    }
    
    public void setMediator(ChatRoomMediator mediator) {
        this.mediator = mediator;
    }
}