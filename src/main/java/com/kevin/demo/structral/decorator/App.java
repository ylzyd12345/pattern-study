package com.kevin.demo.structral.decorator;

/**
 * 装饰模式演示类 - 装饰模式中的客户端角色(Client)
 * 演示如何使用装饰模式为对象动态添加功能
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class App {
    
    /**
     * 主方法，演示装饰模式的使用
     * 
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 创建基本电话对象
        Call call = new PhoneCall();
        
        // 为电话添加通话记录功能
        Call recordCall = new RecordDecorator(call);
        System.out.println("-------- 基本电话 + 通话记录 --------");
        recordCall.call("00000");
        
        // 为已添加通话记录的电话再添加翻译功能
        Call translateCall = new TranslateDecorator(recordCall);
        System.out.println("\n-------- 基本电话 + 通话记录 + 翻译 --------");
        translateCall.call("111111");
        
        // 直接使用基本电话
        System.out.println("\n-------- 基本电话 --------");
        call.call("222222");
    }
}