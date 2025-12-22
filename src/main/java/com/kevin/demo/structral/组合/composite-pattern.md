# 组合模式（Composite Pattern）

## 1. 模式概述

组合模式是一种结构型设计模式，它允许将对象组合成树形结构以表示“部分-整体”的层次关系。组合模式使得客户端对单个对象和组合对象的使用具有一致性。

### 1.1 核心意图
- 将对象组合成树形结构以表示“部分-整体”的层次关系
- 使客户端对单个对象和组合对象的使用具有一致性
- 简化客户端代码，无需区分处理单个对象和组合对象

### 1.2 解决的问题
当需要处理对象的层次结构，并且希望客户端能够统一处理单个对象和组合对象时，组合模式可以提供一个统一的接口，简化客户端的操作。

## 2. 模式结构

### 2.1 核心角色

| 角色 | 职责 | 实现类 |
|------|------|--------|
| 抽象构件（Component） | 定义了对象的接口，是组合中的所有对象的共同父类 | File |
| 叶子构件（Leaf） | 表示组合中的叶子节点，没有子节点 | ImgFile、VidioFile |
| 容器构件（Composite） | 表示组合中的分支节点，可以包含其他构件 | Folder |
| 客户端（Client） | 通过Component接口操作组合中的对象 | App |

### 2.2 结构示意图

```
┌─────────────┐
│   Component │
└───────┬─────┘
        │
        ├────────────┐
        │            │
┌───────▼─────┐ ┌────▼─────────┐
│    Leaf     │ │   Composite   │
└─────────────┘ └───────────────┘
                        │
                        └───────────────┐
                                        │
                        ┌───────────────▼───────────────┐
                        │                               │
                ┌───────▼─────┐                 ┌───────▼─────┐
                │    Leaf     │                 │   Composite   │
                └─────────────┘                 └───────────────┘
```

## 3. 实现示例

### 3.1 抽象构件类

```java
package com.kevin.demo.structral.组合;

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
```

### 3.2 容器构件类

```java
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
```

### 3.3 叶子构件类

```java
package com.kevin.demo.structral.组合;

/**
 * 图片文件类 - 组合模式中的叶子构件角色(Leaf)
 * 表示组合中的叶子节点，不能包含其他文件
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class ImgFile extends File {
    
    /**
     * 构造方法
     * 
     * @param name 图片文件名称
     */
    public ImgFile(String name) {
        super(name);
    }

    /**
     * 显示图片文件信息
     */
    @Override
    protected void display() {
        System.out.println("图片文件: " + name);
    }
}
```

```java
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
```

### 3.4 客户端类

```java
package com.kevin.demo.structral.组合;

/**
 * 组合模式演示类 - 组合模式中的客户端角色(Client)
 * 演示如何使用组合模式创建和管理文件系统结构
 * 
 * @author kevin
 * @version 1.0
 * @since 2023-10-15
 */
public class App {
    
    /**
     * 主方法，演示组合模式的使用
     * 
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 创建一个文件夹
        Folder folder = new Folder("C:");
        
        // 创建图片文件和视频文件
        VidioFile vidioFile = new VidioFile("vidio a.avi");
        ImgFile imgFile = new ImgFile("img a.jpg");
        
        // 向文件夹中添加文件
        folder.addFile(imgFile);
        folder.addFile(vidioFile);
        
        // 显示文件夹内容
        folder.display();
        
        System.out.println("\n--------分割线--------\n");
        
        // 直接显示单个文件
        System.out.println("直接显示单个文件:");
        vidioFile.display();
        imgFile.display();
        
        System.out.println("\n--------分割线--------\n");
        
        // 从文件夹中删除文件
        System.out.println("删除视频文件后:");
        folder.delFile(vidioFile);
        folder.display();
    }
}
```

### 3.5 运行结果

```
文件夹: C: 包含以下内容:
图片文件: img a.jpg
视频文件: vidio a.avi

--------分割线--------

直接显示单个文件:
视频文件: vidio a.avi
图片文件: img a.jpg

--------分割线--------

删除视频文件后:
文件夹: C: 包含以下内容:
图片文件: img a.jpg
```

## 4. 优缺点分析

### 4.1 优点
- **一致性**：客户端可以统一处理单个对象和组合对象
- **可扩展性**：可以方便地添加新的构件类型，符合开闭原则
- **简化客户端代码**：客户端无需区分处理单个对象和组合对象，减少了代码的复杂性
- **清晰的层次结构**：通过树形结构清晰地表示了对象的层次关系

### 4.2 缺点
- **灵活性降低**：为了保持一致性，可能会限制某些操作的灵活性
- **设计复杂**：如果设计不当，可能会导致系统过于复杂
- **违反单一职责原则**：容器构件需要同时管理子构件和实现自身功能

## 5. 适用场景

### 5.1 应用场景
- 当需要表示对象的层次结构（部分-整体关系）时
- 当希望客户端统一处理单个对象和组合对象时
- 当需要忽略单个对象和组合对象的差异时

### 5.2 实际应用
- 文件系统：文件和文件夹的层次结构
- GUI组件：窗口、面板、按钮等的组合
- 组织结构：公司的部门和员工的层次结构
- XML/JSON文档：节点和子节点的层次结构

## 6. 设计原则

组合模式遵循以下设计原则：
- **单一职责原则**：抽象构件只定义基本接口，具体实现由子类完成
- **开闭原则**：可以在不修改现有代码的情况下添加新的构件类型
- **依赖倒置原则**：客户端依赖于抽象构件，不依赖于具体实现

## 7. 与其他模式的比较

### 7.1 组合模式 vs 装饰器模式
- **组合模式**：关注对象的层次结构，实现部分-整体的关系
- **装饰器模式**：关注动态地为对象添加额外的责任

### 7.2 组合模式 vs 迭代器模式
- **组合模式**：提供了访问组合对象的统一接口
- **迭代器模式**：提供了遍历组合对象的统一方式

### 7.3 组合模式 vs 访问者模式
- **组合模式**：将对象组合成树形结构
- **访问者模式**：在不改变对象结构的情况下，为对象添加新的操作

## 8. 变体和扩展

### 8.1 安全式组合模式
在安全式组合模式中，抽象构件只定义了所有构件共有的接口，而容器构件特有的接口（如添加、删除子构件）只在容器构件中定义。这种方式更安全，但客户端需要区分处理叶子构件和容器构件。

### 8.2 透明式组合模式
在透明式组合模式中，抽象构件定义了所有构件（包括叶子构件和容器构件）的接口，包括添加、删除子构件等方法。这种方式更透明，但叶子构件需要提供这些方法的空实现。

### 8.3 组合模式的扩展
- 可以在组合模式中引入迭代器模式，方便遍历组合对象
- 可以在组合模式中引入访问者模式，为组合对象添加新的操作
- 可以在组合模式中引入工厂模式，简化构件的创建

## 9. 总结

组合模式是一种用于处理对象层次结构的设计模式，它允许客户端统一处理单个对象和组合对象，简化了客户端代码。组合模式通过抽象构件、叶子构件和容器构件的角色划分，实现了部分-整体的层次关系。

组合模式广泛应用于文件系统、GUI组件、组织结构等需要表示对象层次结构的场景。它遵循单一职责原则和开闭原则，具有良好的可扩展性和灵活性。

在实际开发中，组合模式可以帮助我们构建清晰、灵活的对象层次结构，提高代码的可维护性和可扩展性。