package com.kevin.demo.behavioral.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * 具体聊天室中介者
 * <p>
 * 中介者模式中的具体中介者角色(ConcreteMediator)，实现了中介者接口，协调各个同事对象之间的交互
 * 
 * @author Kevin
 */
public class ConcreteChatRoom implements ChatRoomMediator {
    
    /**
     * 保存注册的用户
     */
    private Map<String, User> userMap;
    
    /**
     * 构造方法
     */
    public ConcreteChatRoom() {
        this.userMap = new HashMap<>();
    }
    
    /**
     * 发送消息
     * 
     * @param message 消息内容
     * @param userId 发送者ID
     */
    @Override
    public void sendMessage(String message, String userId) {
        User sender = userMap.get(userId);
        if (sender == null) {
            System.out.println("用户" + userId + "不存在！");
            return;
        }
        
        // 向所有用户发送消息（除了发送者自己）
        for (Map.Entry<String, User> entry : userMap.entrySet()) {
            if (!entry.getKey().equals(userId)) {
                User receiver = entry.getValue();
                receiver.receiveMessage(message, sender.getName());
            }
        }
    }
    
    /**
     * 注册用户
     * 
     * @param user 用户对象
     */
    @Override
    public void registerUser(User user) {
        if (user != null && !userMap.containsKey(user.getId())) {
            userMap.put(user.getId(), user);
            user.setMediator(this);
            System.out.println("用户" + user.getName() + "注册成功！");
        }
    }
}