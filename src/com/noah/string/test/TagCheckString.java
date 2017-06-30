package com.noah.string.test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class TagCheckString {

	public static void main(String[] args) {

		String str = "<sound-提示语>下面你有50秒钟的时间准备.mp3</sound-提示语><sound-提示音>“滴”.mp3</sound-提示音><sound-提示语>开始录音.mp3</sound-提示语><sound-听力材料>&&2&&题干声音-Oh, the sun is shining so hard.mp3</sound-听力材料>";
		
		String startTag = "";
		String endTag = "";
		if (str.indexOf("<") > -1 && str.indexOf(">") > -1) {
			startTag = str.substring(str.indexOf("<"),(str.indexOf(">") + 1));
		}else{
			System.out.println("格式不正确");
		}
		if(str.lastIndexOf("</") > -1 && str.lastIndexOf(">") > -1){
			endTag = str.substring(str.lastIndexOf("</"),(str.lastIndexOf(">") + 1));
		}else{
			System.out.println("格式不正确");
		}
		
		System.out.println("开始标签：" + startTag);
		System.out.println("结束标签:" + endTag);
		
		
		StringBuilder temp = new StringBuilder(); // 存放标签
		Map<String, Integer> startTagMap = new HashMap<String, Integer>();
		Map<String, Integer> endTagMap = new HashMap<String, Integer>();
		
		StringBuffer centerContent = new StringBuffer();
		
		char current = ' '; // 当前 & 上一个
		
		int ltSum = 0;
		for (int i = 0; i < str.length();) {
			current = str.charAt(i++);
			if (current == '<') {
				current = str.charAt(i++);
				if (current == '/') {					//结束标签
					current = str.charAt(i++);
					while (i<str.length() && current != '>') {
						temp.append(current);
						current = str.charAt(i++);
					}
					if (endTagMap.containsKey(temp.toString())) {
						endTagMap.put(temp.toString(), (endTagMap.get(temp.toString()) + 1));
					}else{
						endTagMap.put(temp.toString(), 1);
					}
					temp.delete(0, temp.length());
				}else{									//开始标签
					
					while (i<str.length() && current != '>') {
						temp.append(current);
						current = str.charAt(i++);
					}
					if (startTagMap.containsKey(temp.toString())) {
						startTagMap.put(temp.toString(), (startTagMap.get(temp.toString()) + 1));
					}else{
						startTagMap.put(temp.toString(), 1);
					}
					temp.delete(0, temp.length());
					
				}
				
			}
			
			if(current == '>'){
				ltSum++;
				if (ltSum >= 2) {
					ltSum = 0;
					centerContent.append(",");
				}
			}else{
				centerContent.append(current);
			}
			
		}
		String content = centerContent.substring(0,centerContent.length()-1);
		System.out.println(content.substring(0,content.indexOf("&")) + content.substring(content.lastIndexOf("&")+1));
		
		for(Iterator<Entry<String, Integer>> start = startTagMap.entrySet().iterator();start.hasNext();){
			Entry<String, Integer> startEntry = start.next();
			
			System.out.println("key:" + startEntry.getKey() + "  value:" + startEntry.getValue());
		}
		
		for(Iterator<Entry<String, Integer>> end = endTagMap.entrySet().iterator();end.hasNext();){
			Entry<String, Integer> endEntry = end.next();
			
			System.out.println("key:" + endEntry.getKey() + "  value:" + endEntry.getValue());
		}
		
		
		String cont = "##分值##\r\n20\r\n";
		String indexCont = "##分值##\r\n";
		System.out.println(cont.substring(cont.indexOf("##分值##\r\n")+indexCont.length()));
		
		BigDecimal bg1 = new BigDecimal("20");
		BigDecimal bg2 = new BigDecimal("10");
		bg2 = bg2.add(new BigDecimal("10"));
		
		System.out.println("bg1:" + bg1 + "--bg2:" + bg2);
		
		if (bg1.equals(bg2)) {
			System.out.println("==");
		}
		
		
	}

}
