package com.noah.file.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class RemoveFiles {

	public static void main(String[] args) {
		removeFile("D:\\uploadFiles\\dictionary\\牛津中阶zlh\\牛津中阶zlh\\插图\\cable8.jpg", "D:\\uploadFiles\\dictionary\\publish\\牛津中阶zlh\\牛津中阶zlh\\插图\\cable8.jpg");
	}
	
	public static void removeFile(String oldFile,String newFile){
		File nFile = new File(newFile);
		if (nFile.isDirectory()) {
			if (!nFile.exists()) {
				nFile.mkdirs();
			}
		}else {
			if(!nFile.getParentFile().exists()){
				nFile.getParentFile().mkdirs();
			}
		}
		
		File oFile = new File(oldFile);
		String[] oldFileLists = oFile.list();
		
		File temp = null;
		FileInputStream is = null;
		FileOutputStream os = null;
		try {
			if (null != oldFileLists && oldFileLists.length > 0) {
				
				for (int i = 0; i < oldFileLists.length; i++) {
					
					if (oldFile.endsWith(File.separator)) {
						temp = new File(oldFile + oldFileLists[i]);
					} else {
						temp = new File(oldFile + File.separator + oldFileLists[i]);
					}
					
					if (temp.isDirectory()) {
						removeFile(temp.getAbsolutePath(), newFile + File.separator
								+ oldFileLists[i]);
					} else {
						is = new FileInputStream(temp);
						os = new FileOutputStream(newFile + File.separator + temp.getName());
						
						byte[] bt = new byte[1024*5];
						int len = -1;
						while(-1 != (len = is.read(bt, 0, bt.length))){
							os.write(bt, 0, len);
						}
						
						os.close();
						is.close();
						
					}
					
				}
			}
			else {
				is = new FileInputStream(oFile);
				os = new FileOutputStream(newFile);
				
				byte[] bt = new byte[1024*5];
				int len = -1;
				while(-1 != (len = is.read(bt, 0, bt.length))){
					os.write(bt,0,len);
				}
				os.close();
				is.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
