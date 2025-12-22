package com.kevin.demo.structural.composite;

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
    
    private ArrayList<File> files = new ArrayList<>();
    
    public Folder(String name) {
        super(name);
    }

    @Override
    protected void display() {
        System.out.println("文件夹: " + name + " 包含以下内容:");
        for (File file : files) {
            file.display();
        }
    }
    
    public void addFile(File file) {
        files.add(file);
    }
    
    public void delFile(File file) {
        files.remove(file);
    }
}
