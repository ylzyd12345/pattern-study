package com.kevin.demo.behavioral.解释;

import java.util.HashMap;
import java.util.Map;

public class Context {
	
	private Map<Variable, Constant> map = new HashMap<>();

	public boolean lookup(Variable variable) {
		return map.get(variable).interpret(this);
	}
	
	public void assign(Variable variable, Constant constant) {
		map.put(variable, constant);
	}
	
}
