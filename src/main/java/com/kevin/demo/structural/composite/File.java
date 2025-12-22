package com.kevin.demo.structural.composite;

/**
 * 文件抽象类 - 组合模式中的抽象构件角色(Component)
 * 定义了文件和文件夹的共同接口
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public abstract class File {
    
    /**
     * 文件名称
     */
    protected String name;

    /**
     * 构造方法
     * 
     * @param name 文件名称
     */
    public File(String name) {
        this.name = name;
    }

    /**
     * 显示文件/文件夹内容
     */
    protected abstract void display();

    /**
     * 获取文件名称
     * 
     * @return 文件名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置文件名称
     * 
     * @param name 文件名称
     */
    public void setName(String name) {
        this.name = name;
    }
}
