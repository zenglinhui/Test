package com.noah.string.test;

public class ChangeString {

	public static void main(String[] args) {
		int loopTime = 50000;
		Integer i = 0;
		long startTime = System.currentTimeMillis();
		String str;
		for (int j = 0; j < loopTime; j++) {
			str = String.valueOf(i);
		}

		System.out.println("String.valueOf()："
				+ (System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for (int j = 0; j < loopTime; j++) {
			str = i.toString();
		}

		System.out.println("Integer.toString()："
				+ (System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for (int j = 0; j < loopTime; j++) {

			str = i + "";

		}

		System.out.println("i + \"\"："
				+ (System.currentTimeMillis() - startTime) + "ms");

	}

}
