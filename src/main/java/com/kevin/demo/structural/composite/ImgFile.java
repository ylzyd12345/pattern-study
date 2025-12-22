package com.kevin.demo.structural.composite;

/**
 * 图片文件类 - 组合模式中的叶子构件角色(Leaf)
 * 表示组合中的叶子节点，不能包含其他文件
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class ImgFile extends File {
    
    public ImgFile(String name) {
        super(name);
    }

    @Override
    protected void display() {
        System.out.println("图片文件: " + name);
    }
}
