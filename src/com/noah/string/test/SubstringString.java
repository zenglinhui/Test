package com.noah.string.test;

public class SubstringString {

	public static void main(String[] args) {
		String str = "null\r\n30\r\n##总分值##\r\n13";
		
		System.out.println(str);
		
		String name = "<四川省-成都市-2016-初中毕业升学考试>成都市2016年初中毕业升学文化考试";
		
		String[] names = name.substring(name.indexOf("<") + 1,name.indexOf(">")).split("-");
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i].replace("<", "").replace(">", ""));
		}
		
		System.out.println(getCount(name, "-"));
	}
	
	public static int getCount(String content,String key){
		
		int index = 0;			//字符出现在字符串中的位置
		
		int count = 0;			//字符出现次数
		
		while(-1 != (index = content.indexOf(key,index))){
			index += key.length();
			count++;
		}
		
		return count;
		
	}

}
