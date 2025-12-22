package com.kevin.demo.behavioral.mediator;

/**
 * 中介模式演示应用
 * <p>
 * 展示如何使用中介者模式实现聊天室功能
 * 
 * @author Kevin
 */
public class App {
    
    public static void main(String[] args) {
        // 创建聊天室中介者
        ChatRoomMediator chatRoom = new ConcreteChatRoom();
        
        // 创建用户
        User user1 = new User("1", "Alice");
        User user2 = new User("2", "Bob");
        User user3 = new User("3", "Charlie");
        
        // 注册用户到聊天室
        chatRoom.registerUser(user1);
        chatRoom.registerUser(user2);
        chatRoom.registerUser(user3);
        
        System.out.println("\n=== 开始聊天 ===");
        
        // 用户发送消息
        user1.sendMessage("大家好！");
        System.out.println();
        
        user2.sendMessage("Hello Alice!");
        System.out.println();
        
        user3.sendMessage("欢迎加入聊天室！");
    }
}
