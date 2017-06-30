package com.noah.socket.test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServiceSocket {

	public static void main(String[] args) throws Exception {
		
		ServerSocket socket = new ServerSocket(6000);
		
		Socket skt = socket.accept();
		
		InputStream is = skt.getInputStream();
		
		byte[] bt = new byte[200];
		
		int len = is.read(bt,0,bt.length);
		
		System.out.println(new String(bt,0,len));
		/*int len = 0;
		
		while(-1 != (len = is.read(bt,0,bt.length))){
			System.out.println(new String(bt,0,len));
		}*/
		
		
		OutputStream os = skt.getOutputStream();
		
		os.write("welcome".getBytes());
		
		is.close();
		os.close();
		socket.close();
		
	}
	
}
