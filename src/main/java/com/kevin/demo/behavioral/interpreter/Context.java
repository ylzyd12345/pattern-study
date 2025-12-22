package com.kevin.demo.behavioral.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * Context类
 * 
 * @author Kevin
 * @version 1.0
 * @since 1.0.0
 */
public class Context {
	
	private Map<Variable, Constant> map = new HashMap<>();

	public boolean lookup(Variable variable) {
		return map.get(variable).interpret(this);
	}
	
	public void assign(Variable variable, Constant constant) {
		map.put(variable, constant);
	}
	
}
