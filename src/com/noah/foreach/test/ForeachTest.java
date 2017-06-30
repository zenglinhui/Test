package com.noah.foreach.test;

public class ForeachTest {

	public static void main(String[] args) {
		for(int i = 0; i < 10; i++){
			i++;
			System.out.print(i + ",");
		}
		System.out.println("-------------------");
		for(int j = 0; j < 10; j++){
			int sum = (j + 1) * 2;
			System.out.print(j + ",");
		}

	}

}
