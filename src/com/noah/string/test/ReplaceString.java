package com.noah.string.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceString {

	public static void main(String[] args) {
		String str = "＜sb's ears are burning＞";
		char[] cr = str.toLowerCase().toCharArray();
		String reg = "^[a-zA-Z]$";
		Pattern pt = Pattern.compile(reg);
		StringBuffer sb = new StringBuffer();
		//把字符串中不是字母的字符找出来替换成空字符串
		for (int i = 0; i < cr.length; i++) {
			Matcher mc = pt.matcher(String.valueOf(cr[i]));
			if(mc.matches()){
				sb.append(cr[i]);
			}else {
				if ("'".equals(String.valueOf(cr[i]))) {
					sb.append("");
				}else{
					sb.append(" ");
				}
				
			}
		}
		str = sb.toString().replaceAll("  ", " ").trim();
		
		System.out.println(str);
		
	}
	
}
