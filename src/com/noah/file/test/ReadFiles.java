package com.noah.file.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFiles {

	public static void main(String[] args) {
		readFile("F:\\zlhfile\\做过项目的文件\\新英汉词典文件\\enchall_org.txt");
	}
	
	
	public static void readFile(String path){
		
		File rFile = new File(path);
		try {
			FileInputStream fInput = new FileInputStream(rFile);
			InputStreamReader reader = new InputStreamReader(fInput,"GBK");
			BufferedReader buffReader = new BufferedReader(reader);
			String line = null;
			while(null != (line = buffReader.readLine())){
				//System.out.println(line);
				String[] arrayLine = line.split("\\t");
				for (int i = 0; i < arrayLine.length; i++) {
					System.out.print(arrayLine[i] + "\t");
				}
				System.out.println();
			}
			
			buffReader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
