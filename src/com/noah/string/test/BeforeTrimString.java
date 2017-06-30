package com.noah.string.test;

public class BeforeTrimString {

	public static void main(String[] args) {
		String str1 = "  a  under the cosh";
		for (Byte by : str1.getBytes()) {
			System.out.print(by + "\t");
		}
		System.out.println();
		for (Character chars : str1.toCharArray()) {
			System.out.print(chars);
		}
		System.out.println();
		int sum = 0;
		for (int i = 0; i< str1.getBytes().length; i++) {
			Byte by = str1.getBytes()[i];
			if (i == 0) {
				if (by != 32) {
					break;
				}
			}else {
				if (str1.getBytes()[i - 1] != 32) {
					break;
				}
			}
			sum = i;
			System.out.print(by);
		}
		System.out.println();
		System.out.println(str1.substring(sum));

	}

}
