package com.kevin.demo.structral.组合;

/**
 * 视频文件类 - 组合模式中的叶子构件角色(Leaf)
 * 表示组合中的叶子节点，不能包含其他文件
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class VidioFile extends File {
    
    /**
     * 构造方法
     * 
     * @param name 视频文件名称
     */
    public VidioFile(String name) {
        super(name);
    }

    /**
     * 显示视频文件信息
     */
    @Override
    protected void display() {
        System.out.println("视频文件: " + name);
    }
}