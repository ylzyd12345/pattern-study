package com.kevin.demo.structral.组合;

import java.util.ArrayList;

/**
 * 文件夹类 - 组合模式中的容器构件角色(Composite)
 * 可以包含其他文件或文件夹，实现了添加、删除和显示子文件的功能
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class Folder extends File {
    
    /**
     * 文件夹中的文件列表
     */
    private ArrayList<File> files = new ArrayList<>();
    
    /**
     * 构造方法
     * 
     * @param name 文件夹名称
     */
    public Folder(String name) {
        super(name);
    }

    /**
     * 显示文件夹中的所有文件和子文件夹
     */
    @Override
    protected void display() {
        System.out.println("文件夹: " + name + " 包含以下内容:");
        for (File file : files) {
            file.display();
        }
    }
    
    /**
     * 向文件夹中添加文件或子文件夹
     * 
     * @param file 要添加的文件或文件夹
     */
    public void addFile(File file) {
        files.add(file);
    }
    
    /**
     * 从文件夹中删除文件或子文件夹
     * 
     * @param file 要删除的文件或文件夹
     */
    public void delFile(File file) {
        files.remove(file);
    }
}