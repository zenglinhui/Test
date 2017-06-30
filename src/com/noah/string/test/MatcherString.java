package com.noah.string.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherString {

	public static void main(String[] args) {
		String tcontent = "请听第1段材料，回答第9、10小题。\r\n##大题干##\r\n<准备时间>10S</准备时间>\r\n##原文##\r\n此处是听力原文（9）。\r\n此处是听力原文（9）。\r\n##答题时间##\r\n";
		
		Pattern pt = Pattern.compile("##([\\S]+?)##");
		
		Matcher mc = pt.matcher(tcontent);
		int count = 1;
		while (mc.find()) {
			String group = mc.group();
			
			count = findString(count, tcontent, group);
		}
		
		
		String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
				+ "<nwd-question>"
				+ "<nwd-type>&lt;![CDATA[听说包含题]]&gt;</nwd-type>"
				+ " <nwd-subject>&lt;![CDATA[3]]&gt;</nwd-subject>"
				+ "<nwd-phase>&lt;![CDATA[null]]&gt;</nwd-phase>"
				+ "<nwd-content>"
				+ "<nwd-title-desc>&lt;![CDATA[##题目说明##"
				+ "C）请听下面下面一段独白，根据内容完成句子，每个空格不超过3个单词。听独白前你有50秒钟的时间阅读句子内容。独白读两遍。（第小题1分，共5分）&lt;nwd-file&gt;江西省_13.mp3&lt;/nwd-file&gt;]]&gt;</nwd-title-desc>"
				+ "</nwd-content>"
				+ "<nwd-question>"
				+ "<nwd-type>&lt;![CDATA[听说（套题）]]&gt;</nwd-type>"
				+ "<nwd-content>"
				+ "<nwd-big-title>&lt;![CDATA[##大题干##"
				+ "&lt;准备时间&gt;10S&lt;/准备时间&gt;"
				+ "&lt;sound-听力材料&gt;江西省_14.mp3&lt;/sound-听力材料&gt;"
				+ "]]&gt;</nwd-big-title>"
				+ "<nwd-original>&lt;![CDATA[##原文##"
				+ "此处是听力原文（11）。]]&gt;</nwd-original>"
				+ "</nwd-content>"
				+ "<nwd-question>"
				+ "<nwd-type>&lt;![CDATA[听说填空题]]&gt;</nwd-type>"
				+ "<nwd-difficult>&lt;![CDATA[5]]&gt;</nwd-difficult>"
				+ "<nwd-content>"
				+ "<nwd-score>&lt;![CDATA[##分值##"
				+ "1"
				+ "]]&gt;</nwd-score>"
				+ "<nwd-title>&lt;![CDATA[##题干##"
				+ "23、Green school  &lt;填写区域&gt;____&lt;/填写区域&gt; to tell the radio station about the concert."
				+ "]]&gt;</nwd-title>"
				+ "<nwd-answer>&lt;![CDATA[##答案##"
				+ "&lt;answer&gt;has phoned&lt;/answer&gt; "
				+ "has phoned"
				+ "]]&gt;</nwd-answer>"
				+ "<nwd-analysis>&lt;![CDATA[##解析##"
				+ "因为……所以……]]&gt;</nwd-analysis>"
				+ "</nwd-content>"
				+ "</nwd-question>"
				+ "<nwd-question>"
				+ "<nwd-type>&lt;![CDATA[听说填空题]]&gt;</nwd-type>"
				+ "<nwd-difficult>&lt;![CDATA[3]]&gt;</nwd-difficult>"
				+ "<nwd-content>"
				+ "<nwd-score>&lt;![CDATA[##分值##"
				+ "1"
				+ "]]&gt;</nwd-score>"
				+ "<nwd-title>&lt;![CDATA[##题干##"
				+ "24、The concert will be held on （&lt;填写区域&gt; &lt;/填写区域&gt;） evening"
				+ "]]&gt;</nwd-title>"
				+ " <nwd-answer>&lt;![CDATA[##答案##"
				+ "&lt;answer&gt;Sunday&lt;/answer&gt;"
				+ "Sunday"
				+ "]]&gt;</nwd-answer>"
				+ "<nwd-analysis>&lt;![CDATA[##解析##"
				+ " 因为……所以……"
				+ "&lt;/end&gt;"
				+ "&lt;/包含题end&gt;"
				+ " &lt;nwd-file&gt;一、模仿朗读.mp3&lt;/nwd-file&gt;]]&gt;</nwd-analysis>"
				+ "</nwd-content>"
				+ "</nwd-question>"
				+ "</nwd-question>"
				+ "</nwd-question>";
		
		System.out.println(str.replaceAll("&lt;", "<").replaceAll("&gt;", ">"));
		

	}
	
	public static int findString(int count,String content,String matcher){
		
		
		
		String subString = null;
		
		if (count == 1 && (count = content.indexOf(matcher))> 0) {
			String begin = content.substring(0,count);
			System.out.println(begin);
			subString = content.substring(count,content.indexOf("##",count+matcher.length()));
		}else{
			count = content.indexOf(matcher);
			subString = content.substring(count,(content.indexOf("##",count+matcher.length()) > -1 ? content.indexOf("##",count+matcher.length()) : content.length()));
		}
		System.out.println(subString);
		
		return count;
		
	}

}
