package com.noah.io.test;

public class ConcreteDecorator2 extends Decorator{

	
	public ConcreteDecorator2(Component component) {
		super(component);
	}
	
	@Override
	public void doSomething() {
		super.doSomething();
		System.out.println("功能C");
	}

}
