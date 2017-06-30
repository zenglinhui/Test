package com.noah.io.test;

public class IoTest {

	public static void main(String[] args) {
		ConcreteDecorator2 cd2 = new ConcreteDecorator2(new ConcreteDecorator1(
				new ConcreteComponent()));
		cd2.doSomething();
	}

}
