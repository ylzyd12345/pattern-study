package com.kevin.demo.behavioral.chainOfResponsibility;
/**
 * @author Administrator
 *
 */
public abstract class Handler {
	private Handler nextHandler;

	public Handler getNextHandler() {
		return nextHandler;
	}
	/**
	 * 设置下一个处理者
	 * @param nextHandler 下一个处理者
	 */
	public void setNextHandler(Handler nextHandler) {
		/**
		 * 检查下一个处理者是否为空
		 */
		if (nextHandler == null) {
			throw new IllegalArgumentException("Next handler cannot be null!");
		}
		/**
		 * 检查下一个处理者是否为当前处理者的子类
		 */
		if (this.getClass().equals(nextHandler.getClass())) {
			throw new IllegalArgumentException("Next handler must be different from current handler!");
		}
		this.nextHandler = nextHandler;
	}
	/**
	 * 处理请求
	 * @param req 请求
	 */
	public abstract void process(String req);

}
