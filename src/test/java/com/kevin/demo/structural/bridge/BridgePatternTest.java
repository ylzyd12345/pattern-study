package com.kevin.demo.structural.bridge;

import com.kevin.demo.BasePatternTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 桥接模式测试类
 * 测试桥接模式的实现，包括抽象部分与实现部分的分离
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
@DisplayName("桥接模式测试")
class BridgePatternTest extends BasePatternTest {

    private OperationSystemVersion windowsOS;
    private OperationSystemVersion linuxOS;
    private AVIVidioFile aviFile;
    private RMVBVidioFile rmvbFile;

    @BeforeEach
    void setUp() {
        super.setUp();
        windowsOS = new WindowsOperationSystem();
        linuxOS = new LinuxOperationSystem();
        aviFile = new AVIVidioFile();
        rmvbFile = new RMVBVidioFile();
    }

    @Test
    @DisplayName("测试Windows系统播放AVI文件")
    void testWindowsPlayAVI() {
        aviFile.setOperationSystem(windowsOS);
        aviFile.play();
        
        String output = getConsoleOutput();
        assertTrue(output.contains("Windows操作系统"));
        assertTrue(output.contains("播放AVI视频文件"));
    }

    @Test
    @DisplayName("测试Windows系统播放RMVB文件")
    void testWindowsPlayRMVB() {
        rmvbFile.setOperationSystem(windowsOS);
        rmvbFile.play();
        
        String output = getConsoleOutput();
        assertTrue(output.contains("Windows操作系统"));
        assertTrue(output.contains("播放RMVB视频文件"));
    }

    @Test
    @DisplayName("测试Linux系统播放AVI文件")
    void testLinuxPlayAVI() {
        aviFile.setOperationSystem(linuxOS);
        aviFile.play();
        
        String output = getConsoleOutput();
        assertTrue(output.contains("Linux操作系统"));
        assertTrue(output.contains("播放AVI视频文件"));
    }

    @Test
    @DisplayName("测试Linux系统播放RMVB文件")
    void testLinuxPlayRMVB() {
        rmvbFile.setOperationSystem(linuxOS);
        rmvbFile.play();
        
        String output = getConsoleOutput();
        assertTrue(output.contains("Linux操作系统"));
        assertTrue(output.contains("播放RMVB视频文件"));
    }

    @Test
    @DisplayName("测试桥接模式组合")
    void testBridgeCombinations() {
        // 测试所有可能的组合
        
        // Windows + AVI
        aviFile.setOperationSystem(windowsOS);
        aviFile.play();
        String output1 = getConsoleOutput();
        assertTrue(output1.contains("Windows操作系统"));
        assertTrue(output1.contains("播放AVI视频文件"));
        
        clearConsoleOutput();
        
        // Windows + RMVB
        rmvbFile.setOperationSystem(windowsOS);
        rmvbFile.play();
        String output2 = getConsoleOutput();
        assertTrue(output2.contains("Windows操作系统"));
        assertTrue(output2.contains("播放RMVB视频文件"));
        
        clearConsoleOutput();
        
        // Linux + AVI
        aviFile.setOperationSystem(linuxOS);
        aviFile.play();
        String output3 = getConsoleOutput();
        assertTrue(output3.contains("Linux操作系统"));
        assertTrue(output3.contains("播放AVI视频文件"));
        
        clearConsoleOutput();
        
        // Linux + RMVB
        rmvbFile.setOperationSystem(linuxOS);
        rmvbFile.play();
        String output4 = getConsoleOutput();
        assertTrue(output4.contains("Linux操作系统"));
        assertTrue(output4.contains("播放RMVB视频文件"));
    }

    @Test
    @DisplayName("测试类型识别")
    void testTypeIdentification() {
        // 验证操作系统类型
        assertInstanceOf(WindowsOperationSystem.class, windowsOS);
        assertInstanceOf(LinuxOperationSystem.class, linuxOS);
        assertInstanceOf(OperationSystemVersion.class, windowsOS);
        assertInstanceOf(OperationSystemVersion.class, linuxOS);
        
        // 验证视频文件类型
        assertInstanceOf(AVIVidioFile.class, aviFile);
        assertInstanceOf(RMVBVidioFile.class, rmvbFile);
    }

    @Test
    @DisplayName("测试动态切换操作系统")
    void testDynamicOSSwitch() {
        // 初始设置Windows系统
        aviFile.setOperationSystem(windowsOS);
        aviFile.play();
        String output1 = getConsoleOutput();
        assertTrue(output1.contains("Windows操作系统"));
        
        // 动态切换到Linux系统
        clearConsoleOutput();
        aviFile.setOperationSystem(linuxOS);
        aviFile.play();
        String output2 = getConsoleOutput();
        assertTrue(output2.contains("Linux操作系统"));
        
        // 验证文件类型没有改变
        assertTrue(output2.contains("播放AVI视频文件"));
    }

    @Test
    @DisplayName("测试桥接模式分离原则")
    void testBridgeSeparationPrinciple() {
        // 验证抽象部分和实现部分的分离
        
        // 视频文件类不应该包含具体的操作系统逻辑
        aviFile.setOperationSystem(windowsOS);
        aviFile.play();
        
        // 操作系统类不应该包含具体的文件类型逻辑
        windowsOS.play("测试文件");
        
        String output = getConsoleOutput();
        assertTrue(output.contains("Windows操作系统"));
        assertTrue(output.contains("播放AVI视频文件"));
    }

    @Test
    @DisplayName("测试扩展性 - 新增操作系统")
    void testExtensibilityNewOS() {
        // 创建新的操作系统实现
        OperationSystemVersion macOS = new OperationSystemVersion() {
            @Override
            public void play(String fileName) {
                System.out.println("macOS操作系统播放" + fileName);
            }
        };
        
        // 使用新操作系统
        aviFile.setOperationSystem(macOS);
        aviFile.play();
        
        String output = getConsoleOutput();
        assertTrue(output.contains("macOS操作系统"));
        assertTrue(output.contains("播放AVI视频文件"));
    }

    @Test
    @DisplayName("测试扩展性 - 新增文件类型")
    void testExtensibilityNewFileType() {
        // 创建新的视频文件类型
        class MP4VidioFile {
            private OperationSystemVersion os;
            
            public void setOperationSystem(OperationSystemVersion os) {
                this.os = os;
            }
            
            public void play() {
                os.play("MP4视频文件");
            }
        }
        
        // 使用新文件类型
        MP4VidioFile mp4File = new MP4VidioFile();
        mp4File.setOperationSystem(windowsOS);
        mp4File.play();
        
        String output = getConsoleOutput();
        assertTrue(output.contains("Windows操作系统"));
        assertTrue(output.contains("播放MP4视频文件"));
    }

    @Test
    @DisplayName("测试空指针处理")
    void testNullHandling() {
        // 测试未设置操作系统的情况
        aviFile.setOperationSystem(null);
        
        assertThrows(NullPointerException.class, () -> {
            aviFile.play();
        });
    }

    @Test
    @DisplayName("测试多次播放")
    void testMultiplePlays() {
        aviFile.setOperationSystem(windowsOS);
        
        // 多次播放同一个文件
        for (int i = 0; i < 3; i++) {
            aviFile.play();
        }
        
        String output = getConsoleOutput();
        
        // 验证播放了3次
        int count = 0;
        int index = 0;
        while ((index = output.indexOf("Windows操作系统播放AVI视频文件", index)) != -1) {
            count++;
            index += "Windows操作系统播放AVI视频文件".length();
        }
        assertEquals(3, count);
    }

    @Test
    @DisplayName("测试桥接模式性能")
    void testBridgePerformance() {
        // 测试桥接模式的性能
        assertExecutionTime(() -> {
            for (int i = 0; i < 1000; i++) {
                if (i % 2 == 0) {
                    aviFile.setOperationSystem(windowsOS);
                    aviFile.play();
                } else {
                    rmvbFile.setOperationSystem(linuxOS);
                    rmvbFile.play();
                }
                clearConsoleOutput();
            }
        }, 1000); // 期望在1秒内完成
    }

    @Test
    @DisplayName("测试并发操作")
    void testConcurrentOperations() throws InterruptedException {
        // 多线程测试桥接模式
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            final int threadId = i;
            threads[i] = new Thread(() -> {
                if (threadId % 2 == 0) {
                    AVIVidioFile localAviFile = new AVIVidioFile();
                    localAviFile.setOperationSystem(windowsOS);
                    localAviFile.play();
                } else {
                    RMVBVidioFile localRmvbFile = new RMVBVidioFile();
                    localRmvbFile.setOperationSystem(linuxOS);
                    localRmvbFile.play();
                }
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
    @DisplayName("测试桥接模式设计原则")
    void testBridgeDesignPrinciples() {
        // 验证桥接模式的设计原则
        
        // 1. 抽象部分和实现部分分离
        aviFile.setOperationSystem(windowsOS);
        aviFile.play();
        
        // 2. 两个维度可以独立扩展
        // 可以独立添加新的操作系统或新的文件类型
        
        // 3. 运行时动态组合
        clearConsoleOutput();
        aviFile.setOperationSystem(linuxOS);
        aviFile.play();
        
        String output = getConsoleOutput();
        assertTrue(output.contains("Linux操作系统"));
        assertTrue(output.contains("播放AVI视频文件"));
    }

    @Test
    @DisplayName("测试复杂桥接场景")
    void testComplexBridgeScenario() {
        // 创建复杂的桥接场景
        
        // 多个文件类型
        AVIVidioFile[] aviFiles = new AVIVidioFile[3];
        RMVBVidioFile[] rmvbFiles = new RMVBVidioFile[3];
        
        for (int i = 0; i < 3; i++) {
            aviFiles[i] = new AVIVidioFile();
            rmvbFiles[i] = new RMVBVidioFile();
        }
        
        // 动态分配操作系统
        for (int i = 0; i < 3; i++) {
            OperationSystemVersion os = i % 2 == 0 ? windowsOS : linuxOS;
            aviFiles[i].setOperationSystem(os);
            rmvbFiles[i].setOperationSystem(os);
        }
        
        // 播放所有文件
        for (int i = 0; i < 3; i++) {
            aviFiles[i].play();
            rmvbFiles[i].play();
        }
        
        String output = getConsoleOutput();
        
        // 验证所有组合都被测试
        assertTrue(output.contains("Windows操作系统"));
        assertTrue(output.contains("Linux操作系统"));
        assertTrue(output.contains("播放AVI视频文件"));
        assertTrue(output.contains("播放RMVB视频文件"));
    }
}