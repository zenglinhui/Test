package com.noah.string.test;

import java.math.BigDecimal;

public class BigDecimalFormatString {

	public static void main(String[] args) {
		BigDecimal zbg = new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal bg = zbg.add(new BigDecimal("0.5").setScale(2, BigDecimal.ROUND_HALF_UP));
		System.out.println(bg);
	}

}
