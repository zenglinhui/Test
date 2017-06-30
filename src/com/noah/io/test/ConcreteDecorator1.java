package com.noah.io.test;

public class ConcreteDecorator1 extends Decorator{

	
	public ConcreteDecorator1(Component component) {
		super(component);

	}
	
	public void doSomething(){
		super.doSomething();
		System.out.println("功能B");
	}

}
