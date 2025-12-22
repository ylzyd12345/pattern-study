package com.kevin.demo.creational.抽象factory;

/**
 * HaierFactory接口
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public interface HaierFactory {
	HaierTV createTV();
	HaierWasher createWasher();
}
