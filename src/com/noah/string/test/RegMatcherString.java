package com.noah.string.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegMatcherString {

	public static void main(String[] args) {
		
		String content = "##大题干##\r\n<准备时间>10S</准备时间>\r\n<sound-听力材料>&&2&&江西省_14.mp3</sound-听力材料>\r\n##答案##\r\n<answer>has phoned</answer>\r\n has phoned";
		
		Pattern pt = Pattern.compile("##([\\S\\s]+?)##");
		
		Matcher mc = pt.matcher(content);
		
		while(mc.find()){
			String group = mc.group();
			System.out.println(group.replaceAll("#", ""));
		}
		
		Pattern tagPt = Pattern.compile("<准备时间>([\\S\\s]+?)</准备时间>");
		mc = tagPt.matcher(content);
		while(mc.find()){
			String group = mc.group();
			System.out.println(group.replaceAll("<准备时间>", "").replaceAll("</准备时间>", ""));
		}
		
		Pattern answerPt = Pattern.compile("<answer>([\\s\\S]+?)</answer>");
		mc = answerPt.matcher(content);
		while(mc.find()){
			String group = mc.group();
			System.out.println(group.replaceAll(group, ""));
		}
		
		
		Pattern soundPt = Pattern.compile("<sound-([\\s\\S]+?)>([\\s\\S]+?)</sound-([\\s\\S]+?)>");
		mc = soundPt.matcher(content);
		while(mc.find()){
			String group = mc.group();
			String countGroup = group.replaceAll("<sound-([\\s\\S]+?)>", "").replaceAll("</sound-([\\s\\S]+?)>", "");
			System.out.println(countGroup);
			Pattern soundCountPt = Pattern.compile("&&([\\d]+?)&&");
			Matcher matcher = soundCountPt.matcher(countGroup);
			while(matcher.find()){
				System.out.println(matcher.group());
			}
		}
		
		String ltContent = "{{qowierf094523rsdf.png}}";
		Pattern ltPt = Pattern.compile("\\{\\{([\\s\\S]+?)\\}\\}");
		Matcher ltMc = ltPt.matcher(ltContent);
		if (ltMc.find()) {
			String group = ltMc.group();
			System.out.println(group.replaceAll("\\{", "").replaceAll("\\}", ""));
		}
		
		
		String bc = "##选项##\n\r%%A%%、In the morning.\n\r%%B%%、At night.\n\r%%C%%、In the afternoon.\n\r##原文##";
		Pattern ptb = Pattern.compile("%%([\\S\\s]+?)%%");
		System.out.println(ptb.matcher(bc).find());
		System.out.println(ptb.matcher(bc).matches());
		
		StringBuffer buffer = new StringBuffer();
		String an = "<answer>The new restaurant is near my school.|The new restaurant is close to my school.|The new restaurant is beside my school.|The new restaurant is nor far away from my school.|It's near my school.|It's colse to my school.|It's beside my school.|It's not far away from my school.|The restaurant is near my school.|The restaurant is close to my school.|The restaurant is beside my school.|The restaurant is nor far away from my school.|Near my school.|<answer>Colse to my school.|Bbeside my school.|Not far away from my school.</answer>";
		Pattern anPt = Pattern.compile("<answer>([\\S\\s]+?)</answer>");
		Matcher mtan = anPt.matcher(an);
		if (mtan.find()) {
			String group = mtan.group();
			//group = an.replaceAll(group, "");
			System.out.println("answer:" + group);
			mtan.appendReplacement(buffer, "");
		}
		mtan.appendTail(buffer);
		System.out.println(buffer);
		
		
		String option = "8. What does the boy mean? <选项区域>____</选项区域>";
		Pattern opt = Pattern.compile("<([\\s\\S]+?)>([\\s\\S]+?)</([\\s\\S]+?)>");
		Matcher optMt = opt.matcher(option);
		if (optMt.find()) {
			String group = optMt.group().replaceAll("<([\\s\\S]+?)>", "")
					.replaceAll("</([\\s\\S]+?)>", "");
			System.out.println(group);
		}
		
		String jpgStr = "%%A%%.{{苏三-11-3yw-4.jpg}}";
		Pattern jpgPt = Pattern.compile("\\{\\{([\\s\\S]+?)\\}\\}");
		Matcher jpgMt = jpgPt.matcher(jpgStr);
		if (jpgMt.find()) {
			String group = jpgMt.group();
			group = group.replaceAll("\\{", "").replaceAll("\\}", "");
			System.out.println(group);
		}
		
		
		
	}
	
}
