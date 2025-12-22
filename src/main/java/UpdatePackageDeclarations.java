import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 更新Java文件中的包声明，将中文目录名替换为英文
 */
public class UpdatePackageDeclarations {
    
    // 定义中文目录名到英文目录名的映射
    private static final Map<String, String> DIRECTORY_MAPPINGS = new HashMap<>();
    
    static {
        // 行为型模式
        DIRECTORY_MAPPINGS.put("中介", "mediator");
        DIRECTORY_MAPPINGS.put("命令", "command");
        DIRECTORY_MAPPINGS.put("备忘录", "memento");
        DIRECTORY_MAPPINGS.put("模板", "template");
        DIRECTORY_MAPPINGS.put("状态", "state");
        DIRECTORY_MAPPINGS.put("策略", "strategy");
        DIRECTORY_MAPPINGS.put("观察者", "observer");
        DIRECTORY_MAPPINGS.put("解释", "interpreter");
        DIRECTORY_MAPPINGS.put("访问者", "visitor");
        DIRECTORY_MAPPINGS.put("责任链", "chainOfResponsibility");
        DIRECTORY_MAPPINGS.put("迭代", "iterator");
        
        // 创建型模式
        DIRECTORY_MAPPINGS.put("单例", "singleton");
        DIRECTORY_MAPPINGS.put("原", "prototype");
        DIRECTORY_MAPPINGS.put("工厂", "factory");
        DIRECTORY_MAPPINGS.put("建造者", "builder");
        DIRECTORY_MAPPINGS.put("抽象工厂", "abstractFactory");
        
        // 结构型模式
        DIRECTORY_MAPPINGS.put("享元", "flyweight");
        DIRECTORY_MAPPINGS.put("代理", "proxy");
        DIRECTORY_MAPPINGS.put("外观", "facade");
        DIRECTORY_MAPPINGS.put("桥", "bridge");
        DIRECTORY_MAPPINGS.put("组合", "composite");
        DIRECTORY_MAPPINGS.put("装饰", "decorator");
        DIRECTORY_MAPPINGS.put("适配", "adapter");
        
        // 其他子目录
        DIRECTORY_MAPPINGS.put("不好的例子", "badExample");
        DIRECTORY_MAPPINGS.put("好的例子", "goodExample");
        DIRECTORY_MAPPINGS.put("懒汉", "lazy");
        DIRECTORY_MAPPINGS.put("内部类", "innerClass");
        DIRECTORY_MAPPINGS.put("双检", "doubleCheck");
        DIRECTORY_MAPPINGS.put("枚举", "enum");
        DIRECTORY_MAPPINGS.put("饿汉", "eager");
        DIRECTORY_MAPPINGS.put("工厂方法", "factoryMethod");
        DIRECTORY_MAPPINGS.put("简单工厂", "simpleFactory");
    }
    
    public static void main(String[] args) throws IOException {
        // 设置项目根目录
        Path projectRoot = Paths.get("F:\\codes\\roadmap\\road-step-codes\\pattern-study\\src\\main\\java\\com\\kevin\\demo");
        
        // 遍历所有Java文件
        Files.walk(projectRoot)
             .filter(Files::isRegularFile)
             .filter(path -> path.toString().endsWith(".java"))
             .forEach(UpdatePackageDeclarations::processFile);
        
        System.out.println("所有文件处理完成！");
    }
    
    private static void processFile(Path filePath) {
        try {
            System.out.println("正在处理文件: " + filePath);
            
            // 读取文件内容
            String content = Files.readString(filePath, StandardCharsets.UTF_8);
            
            // 正则表达式匹配包声明
            Pattern pattern = Pattern.compile("^package com\\.kevin\\.demo\\..*;", Pattern.MULTILINE);
            Matcher matcher = pattern.matcher(content);
            
            if (matcher.find()) {
                String originalPackage = matcher.group();
                String newPackage = originalPackage;
                
                // 应用所有目录映射
                for (Map.Entry<String, String> entry : DIRECTORY_MAPPINGS.entrySet()) {
                    String chinese = entry.getKey();
                    String english = entry.getValue();
                    
                    if (newPackage.contains(chinese)) {
                        newPackage = newPackage.replace(chinese, english);
                        System.out.println("  更新: " + chinese + " -> " + english);
                    }
                }
                
                // 如果包声明发生变化，则更新文件
                if (!originalPackage.equals(newPackage)) {
                    System.out.println("  包声明从: " + originalPackage);
                    System.out.println("  包声明到: " + newPackage);
                    
                    String updatedContent = content.replace(originalPackage, newPackage);
                    Files.writeString(filePath, updatedContent, StandardCharsets.UTF_8);
                    System.out.println("  文件已更新");
                } else {
                    System.out.println("  包声明无需更新");
                }
            } else {
                System.out.println("  未找到包声明");
            }
        } catch (IOException e) {
            System.err.println("  处理文件时出错: " + e.getMessage());
        }
    }
}