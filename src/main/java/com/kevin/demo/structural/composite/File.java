package com.kevin.demo.structural.composite;

/**
 * File抽象类 - 组合模式中的抽象构建角色
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public abstract class File {
    protected String name;

    public File(String name) {
        this.name = name;
    }

    protected abstract void display();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}