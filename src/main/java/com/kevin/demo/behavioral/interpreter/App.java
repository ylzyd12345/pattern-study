package com.kevin.demo.behavioral.解释;

/**
 * @author Administrator
 *
 */
public class App {
	public static void main(String[] args) {
		Variable x = new Variable("x");
		Variable y = new Variable("y");

		Context context = new Context();
		context.assign(x, new Constant(true));
		context.assign(y, new Constant(false));

		Expression and = new And(x, y);
		boolean andResult = and.interpret(context);
		System.out.println(and.toString() + ":" + andResult);

		Expression or = new Or(and, x);
		boolean orResult = or.interpret(context);
		System.out.println(or.toString() + ":" + orResult);

		Expression not = new Not(or);
		boolean notResult = not.interpret(context);
		System.out.println(not.toString() + ":" + notResult);

	}
}
