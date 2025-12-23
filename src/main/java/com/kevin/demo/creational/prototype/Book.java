package com.kevin.demo.creational.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 书籍类 - 原型模式中的原型角色(Prototype)
 * <p>
 * 原型模式(Prototype Pattern)：用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象
 * 该类实现了Cloneable和Serializable接口，支持浅拷贝和深拷贝两种复制方式
 * <p>
 * 作为可复制的原型对象，提供了两种复制方法：
 * 1. clone() - 浅拷贝，复制基本类型字段，引用类型字段共享引用
 * 2. deepClone() - 深拷贝，完全复制所有字段，包括引用类型
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public class Book implements Cloneable, Serializable {
    
    /**
     * 序列化版本号
     */
    private static final long serialVersionUID = -2227190595410858190L;
    
    /**
     * 书名
     */
    private String name;
    
    /**
     * 作者
     */
    private String author;
    
    /**
     * 价格
     */
    private double money;

    /**
     * 获取书名
     * 
     * @return 书名字符串
     */
    public String getName() {
        return name;
    }

    /**
     * 设置书名
     * 
     * @param name 书名字符串
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取作者
     * 
     * @return 作者名字符串
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置作者
     * 
     * @param author 作者名字符串
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取价格
     * 
     * @return 书籍价格
     */
    public double getMoney() {
        return money;
    }

    /**
     * 设置价格
     * 
     * @param money 书籍价格
     */
    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * 全参数构造函数
     * 
     * @param name 书名
     * @param author 作者
     * @param money 价格
     */
    public Book(String name, String author, double money) {
        this.name = name;
        this.author = author;
        this.money = money;
    }

    /**
     * 简化构造函数
     * 
     * @param name 书名
     */
    public Book(String name) {
        this.name = name;
    }

    /**
     * 浅拷贝方法
     * <p>
     * 使用Object.clone()方法实现浅拷贝：
     * - 基本类型字段会被复制
     * - 引用类型字段只复制引用，不复制对象
     * 
     * @return 浅拷贝的Book对象
     */
    @Override
    protected Book clone() {
        Book cloneBook = null;
        try {
            cloneBook = (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return cloneBook;
    }
    
    /**
     * 深拷贝方法
     * <p>
     * 使用序列化机制实现深拷贝：
     * - 将对象写入字节流，再从字节流中读出
     * - 完全复制所有字段，包括引用类型字段
     * - 性能开销比浅拷贝大，但复制更彻底
     * 
     * @return 深拷贝的Book对象
     */
    public Book deepClone() {
        Book cloneBook = null;
        try {
            // 将对象写入字节流
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            
            // 从字节流中读出对象
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            cloneBook = (Book) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cloneBook;
    }

    /**
     * 生成书籍信息的字符串表示
     * 
     * @return 包含书名、作者和价格的字符串
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Book [name=");
        builder.append(name);
        builder.append(", author=");
        builder.append(author);
        builder.append(", money=");
        builder.append(money);
        builder.append("]");
        return builder.toString();
    }
}
