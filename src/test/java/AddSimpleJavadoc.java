import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class AddSimpleJavadoc {
    public static void main(String[] args) {
        String basePath = "src/main/java/com/kevin/demo";
        File directory = new File(basePath);
        
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("目录不存在: " + basePath);
            return;
        }
        
        System.out.println("开始为Java文件添加简单Javadoc注释...");
        processDirectory(directory);
        System.out.println("Javadoc注释添加完成！");
    }
    
    private static void processDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files == null) return;
        
        for (File file : files) {
            if (file.isDirectory()) {
                processDirectory(file);
            } else if (file.getName().endsWith(".java")) {
                processJavaFile(file);
            }
        }
    }
    
    private static void processJavaFile(File file) {
        try {
            // 读取文件内容
            List<String> lines = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            }
            
            List<String> newLines = new ArrayList<>();
            boolean inClass = false;
            boolean hasClassJavadoc = false;
            
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                
                    // 检查类定义
                if (line.contains("class ") && !line.contains("public class ") && !line.contains("private class ") && !line.contains("protected class ")) {
                    // 检查内部类
                    continue;
                }
                
                // 添加类或接口注释
                if ((line.contains("class ") || line.contains("interface ")) && !hasClassJavadoc) {
                    // 检查是否已有Javadoc注释
                    if (i > 0) {
                        String prevLine = lines.get(i - 1).trim();
                        if (prevLine.startsWith("/**")) {
                            hasClassJavadoc = true;
                            newLines.add(line);
                            inClass = true;
                            continue;
                        }
                    }
                    
                    // 添加类或接口Javadoc
                    String typeName;
                    String typeDesc;
                    if (line.contains("class ")) {
                        typeName = extractClassName(line);
                        typeDesc = "类";
                    } else {
                        typeName = extractInterfaceName(line);
                        typeDesc = "接口";
                    }
                    
                    newLines.add("/**");
                    newLines.add(" * " + typeName + typeDesc);
                    newLines.add(" * ");
                    newLines.add(" * @author Kevin");
                    newLines.add(" * @version 1.0");
                    newLines.add(" * @since 1.0.0");
                    newLines.add(" */");
                    newLines.add(line);
                    hasClassJavadoc = true;
                    inClass = true;
                } 
                // 添加方法注释
                else if (inClass && (line.trim().startsWith("public ") || line.trim().startsWith("private ") || line.trim().startsWith("protected ")) && line.contains("(")) {
                    // 检查是否已有Javadoc注释
                    if (i > 0) {
                        String prevLine = lines.get(i - 1).trim();
                        if (prevLine.startsWith("/**")) {
                            newLines.add(line);
                            continue;
                        }
                    }
                    
                    // 添加方法Javadoc
                    String methodName = extractMethodName(line);
                    newLines.add("    /**");
                    newLines.add("     * " + methodName + "方法");
                    newLines.add("     * ");
                    
                    // 简单参数处理
                    if (line.contains(",")) {
                        newLines.add("     * @param 参数1 参数描述");
                    } else if (line.contains("(")) {
                        newLines.add("     * @param 参数 参数描述");
                    }
                    
                    // 简单返回值处理
                    if (!line.contains("void ")) {
                        newLines.add("     * ");
                        newLines.add("     * @return 返回值描述");
                    }
                    
                    newLines.add("     */");
                    newLines.add(line);
                }
                // 添加字段注释
                else if (inClass && (line.trim().startsWith("private ") || line.trim().startsWith("public ") || line.trim().startsWith("protected ")) && line.contains(";")) {
                    // 跳过方法定义
                    if (line.contains("(")) {
                        newLines.add(line);
                        continue;
                    }
                    
                    // 检查是否已有注释
                    if (i > 0) {
                        String prevLine = lines.get(i - 1).trim();
                        if (prevLine.startsWith("/**") || prevLine.startsWith("//")) {
                            newLines.add(line);
                            continue;
                        }
                    }
                    
                    // 添加字段Javadoc
                    String fieldName = extractFieldName(line);
                    newLines.add("    /**");
                    newLines.add("     * " + fieldName);
                    newLines.add("     */");
                    newLines.add(line);
                }
                else {
                    newLines.add(line);
                }
            }
            
            // 如果内容有变化，写回文件
            if (!lines.equals(newLines)) {
                try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(file), StandardCharsets.UTF_8))) {
                    for (String line : newLines) {
                        writer.write(line);
                        writer.newLine();
                    }
                }
                System.out.println("已更新: " + file.getPath());
            }
            
        } catch (IOException e) {
            System.err.println("处理文件时出错: " + file.getPath());
            e.printStackTrace();
        }
    }
    
    private static String extractClassName(String line) {
        String[] parts = line.split("class ");
        if (parts.length > 1) {
            String classNamePart = parts[1].split(" ")[0];
            return classNamePart.replace("{", "").trim();
        }
        return "ClassName";
    }
    
    private static String extractInterfaceName(String line) {
        int interfaceIndex = line.indexOf("interface ") + 10;
        int braceIndex = line.indexOf("{");
        int extendsIndex = line.indexOf("extends");
        
        int endIndex = braceIndex;
        if (extendsIndex != -1 && extendsIndex < endIndex) {
            endIndex = extendsIndex;
        }
        
        return line.substring(interfaceIndex, endIndex).trim();
    }
    
    private static String extractMethodName(String line) {
        String[] parts = line.split(" ");
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].contains("(")) {
                return parts[i].replace("(", "").trim();
            }
        }
        return "methodName";
    }
    
    private static String extractFieldName(String line) {
        String[] parts = line.split(" ");
        if (parts.length > 1) {
            String fieldName = parts[parts.length - 1].replace(";" , "").trim();
            return fieldName;
        }
        return "fieldName";
    }
}