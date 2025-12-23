package com.kevin.demo.structural.composite;

import com.kevin.demo.BasePatternTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 组合模式测试类
 * 测试组合模式的实现，包括统一对待单个对象和组合对象
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
@DisplayName("组合模式测试")
class CompositePatternTest extends BasePatternTest {

    private File textFile;
    private File imgFile;
    private File vidioFile;
    private Folder folder;
    private Folder subFolder;

    @BeforeEach
    void setUp() {
        super.setUp();
        textFile = new File("文本文件.txt");
        imgFile = new ImgFile("图片文件.jpg");
        vidioFile = new VidioFile("视频文件.mp4");
        folder = new Folder("主文件夹");
        subFolder = new Folder("子文件夹");
    }

    @Test
    @DisplayName("测试单个文件操作")
    void testSingleFileOperations() {
        // 测试文本文件
        textFile.killVirus();
        String output = getConsoleOutput();
        assertTrue(output.contains("杀灭文本文件：文本文件.txt"));
        
        clearConsoleOutput();
        
        // 测试图片文件
        imgFile.killVirus();
        output = getConsoleOutput();
        assertTrue(output.contains("杀灭图片文件：图片文件.jpg"));
        
        clearConsoleOutput();
        
        // 测试视频文件
        vidioFile.killVirus();
        output = getConsoleOutput();
        assertTrue(output.contains("杀灭视频文件：视频文件.mp4"));
    }

    @Test
    @DisplayName("测试文件夹基本操作")
    void testFolderBasicOperations() {
        // 添加文件到文件夹
        folder.add(textFile);
        folder.add(imgFile);
        folder.add(vidioFile);
        
        // 对文件夹进行杀毒操作
        folder.killVirus();
        
        String output = getConsoleOutput();
        
        // 验证文件夹和所有文件都被处理
        assertTrue(output.contains("杀灭文件夹：主文件夹"));
        assertTrue(output.contains("杀灭文本文件：文本文件.txt"));
        assertTrue(output.contains("杀灭图片文件：图片文件.jpg"));
        assertTrue(output.contains("杀灭视频文件：视频文件.mp4"));
    }

    @Test
    @DisplayName("测试嵌套文件夹操作")
    void testNestedFolderOperations() {
        // 创建嵌套结构
        subFolder.add(textFile);
        subFolder.add(imgFile);
        folder.add(subFolder);
        folder.add(vidioFile);
        
        // 对主文件夹进行杀毒操作
        folder.killVirus();
        
        String output = getConsoleOutput();
        
        // 验证所有层级都被处理
        assertTrue(output.contains("杀灭文件夹：主文件夹"));
        assertTrue(output.contains("杀灭文件夹：子文件夹"));
        assertTrue(output.contains("杀灭文本文件：文本文件.txt"));
        assertTrue(output.contains("杀灭图片文件：图片文件.jpg"));
        assertTrue(output.contains("杀灭视频文件：视频文件.mp4"));
    }

    @Test
    @DisplayName("测试类型识别")
    void testTypeIdentification() {
        // 验证文件类型
        assertInstanceOf(File.class, textFile);
        assertInstanceOf(ImgFile.class, imgFile);
        assertInstanceOf(VidioFile.class, vidioFile);
        
        // 验证文件夹类型
        assertInstanceOf(Folder.class, folder);
        assertInstanceOf(Folder.class, subFolder);
        
        // 验证继承关系
        assertTrue(textFile instanceof File);
        assertTrue(imgFile instanceof File);
        assertTrue(vidioFile instanceof File);
        assertTrue(folder instanceof File); // Folder应该继承File接口
        assertTrue(subFolder instanceof File);
    }

    @Test
    @DisplayName("测试文件夹添加和移除")
    void testFolderAddAndRemove() {
        // 添加文件
        folder.add(textFile);
        folder.add(imgFile);
        
        // 验证添加成功
        folder.killVirus();
        String output1 = getConsoleOutput();
        assertTrue(output1.contains("杀灭文本文件：文本文件.txt"));
        assertTrue(output1.contains("杀灭图片文件：图片文件.jpg"));
        
        // 移除文件
        folder.remove(textFile);
        
        // 验证移除成功
        clearConsoleOutput();
        folder.killVirus();
        String output2 = getConsoleOutput();
        assertFalse(output2.contains("杀灭文本文件：文本文件.txt"));
        assertTrue(output2.contains("杀灭图片文件：图片文件.jpg"));
    }

    @Test
    @DisplayName("测试空文件夹操作")
    void testEmptyFolderOperations() {
        // 测试空文件夹
        Folder emptyFolder = new Folder("空文件夹");
        emptyFolder.killVirus();
        
        String output = getConsoleOutput();
        assertTrue(output.contains("杀灭文件夹：空文件夹"));
        // 不应该包含任何文件的处理信息
    }

    @Test
    @DisplayName("测试复杂嵌套结构")
    void testComplexNestedStructure() {
        // 创建复杂的多层嵌套结构
        Folder rootFolder = new Folder("根文件夹");
        Folder level1Folder1 = new Folder("一级文件夹1");
        Folder level1Folder2 = new Folder("一级文件夹2");
        Folder level2Folder = new Folder("二级文件夹");
        
        // 构建嵌套结构
        level2Folder.add(textFile);
        level1Folder1.add(level2Folder);
        level1Folder1.add(imgFile);
        level1Folder2.add(vidioFile);
        rootFolder.add(level1Folder1);
        rootFolder.add(level1Folder2);
        
        // 对根文件夹进行操作
        rootFolder.killVirus();
        
        String output = getConsoleOutput();
        
        // 验证所有层级都被处理
        assertTrue(output.contains("杀灭文件夹：根文件夹"));
        assertTrue(output.contains("杀灭文件夹：一级文件夹1"));
        assertTrue(output.contains("杀灭文件夹：一级文件夹2"));
        assertTrue(output.contains("杀灭文件夹：二级文件夹"));
        assertTrue(output.contains("杀灭文本文件：文本文件.txt"));
        assertTrue(output.contains("杀灭图片文件：图片文件.jpg"));
        assertTrue(output.contains("杀灭视频文件：视频文件.mp4"));
    }

    @Test
    @DisplayName("测试组合模式统一接口")
    void testCompositeUniformInterface() {
        // 验证单个文件和文件夹使用相同的接口
        File[] files = {textFile, imgFile, vidioFile, folder};
        
        // 统一处理所有对象
        for (File file : files) {
            file.killVirus();
        }
        
        String output = getConsoleOutput();
        
        // 验证所有对象都被处理
        assertTrue(output.contains("杀灭文本文件：文本文件.txt"));
        assertTrue(output.contains("杀灭图片文件：图片文件.jpg"));
        assertTrue(output.contains("杀灭视频文件：视频文件.mp4"));
        assertTrue(output.contains("杀灭文件夹：主文件夹"));
    }

    @Test
    @DisplayName("测试文件夹名称")
    void testFolderNames() {
        // 验证文件夹名称
        assertEquals("主文件夹", folder.getName());
        assertEquals("子文件夹", subFolder.getName());
        
        // 测试名称在操作中的使用
        folder.killVirus();
        String output = getConsoleOutput();
        assertTrue(output.contains("杀灭文件夹：主文件夹"));
    }

    @Test
    @DisplayName("测试文件名称")
    void testFileNames() {
        // 验证文件名称
        assertEquals("文本文件.txt", textFile.getName());
        assertEquals("图片文件.jpg", imgFile.getName());
        assertEquals("视频文件.mp4", vidioFile.getName());
        
        // 测试名称在操作中的使用
        textFile.killVirus();
        String output = getConsoleOutput();
        assertTrue(output.contains("杀灭文本文件：文本文件.txt"));
    }

    @Test
    @DisplayName("测试组合模式扩展性")
    void testCompositeExtensibility() {
        // 创建新的文件类型
        class AudioFile extends File {
            public AudioFile(String name) {
                super(name);
            }
            
            @Override
            public void killVirus() {
                System.out.println("杀灭音频文件：" + getName());
            }
        }
        
        // 使用新文件类型
        AudioFile audioFile = new AudioFile("音频文件.mp3");
        folder.add(audioFile);
        folder.killVirus();
        
        String output = getConsoleOutput();
        assertTrue(output.contains("杀灭音频文件：音频文件.mp3"));
    }

    @Test
    @DisplayName("测试组合模式性能")
    void testCompositePerformance() {
        // 创建大型组合结构
        Folder largeFolder = new Folder("大文件夹");
        for (int i = 0; i < 100; i++) {
            largeFolder.add(new File("文件" + i + ".txt"));
        }
        
        // 测试性能
        assertExecutionTime(() -> {
            for (int i = 0; i < 10; i++) {
                largeFolder.killVirus();
                clearConsoleOutput();
            }
        }, 1000); // 期望在1秒内完成
    }

    @Test
    @DisplayName("测试并发操作")
    void testConcurrentOperations() throws InterruptedException {
        // 多线程测试组合模式
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            final int threadId = i;
            threads[i] = new Thread(() -> {
                Folder localFolder = new Folder("线程" + threadId + "文件夹");
                localFolder.add(new File("文件" + threadId + ".txt"));
                localFolder.killVirus();
            });
        }
        
        // 启动所有线程
        for (Thread thread : threads) {
            thread.start();
        }
        
        // 等待所有线程完成
        for (Thread thread : threads) {
            thread.join();
        }
        
        // 验证没有异常抛出
        String output = getConsoleOutput();
        assertTrue(output.length() > 0);
    }

    @Test
    @DisplayName("测试边界条件")
    void testEdgeCases() {
        // 测试添加null文件
        assertDoesNotThrow(() -> {
            folder.add(null);
        });
        
        // 测试移除不存在的文件
        assertDoesNotThrow(() -> {
            folder.remove(textFile); // textFile没有被添加过
        });
        
        // 测试移除null文件
        assertDoesNotThrow(() -> {
            folder.remove(null);
        });
    }

    @Test
    @DisplayName("测试组合模式设计原则")
    void testCompositeDesignPrinciples() {
        // 验证组合模式的设计原则
        
        // 1. 统一接口：单个对象和组合对象使用相同接口
        File singleFile = textFile;
        File compositeFile = folder;
        
        singleFile.killVirus();
        clearConsoleOutput();
        compositeFile.killVirus();
        
        String output = getConsoleOutput();
        assertTrue(output.contains("杀灭文件夹：主文件夹"));
        
        // 2. 透明性：客户端不需要区分单个对象和组合对象
        File[] mixedObjects = {textFile, folder, imgFile};
        for (File obj : mixedObjects) {
            obj.killVirus();
            clearConsoleOutput();
        }
        
        // 3. 递归结构：组合对象可以包含其他组合对象
        subFolder.add(textFile);
        folder.add(subFolder);
        folder.killVirus();
        
        output = getConsoleOutput();
        assertTrue(output.contains("杀灭文件夹：主文件夹"));
        assertTrue(output.contains("杀灭文件夹：子文件夹"));
        assertTrue(output.contains("杀灭文本文件：文本文件.txt"));
    }
}