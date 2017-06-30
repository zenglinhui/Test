package com.noah.socket.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClientSocket {

	public static void main(String[] args) throws IOException {
		
		Socket skt = new Socket("127.0.0.1",6000);
		
		OutputStream os = skt.getOutputStream();
		
		os.write("hello".getBytes());
		
		InputStream is = skt.getInputStream();
		
		byte[] bt = new byte[200];
		
		int len = is.read(bt,0,bt.length);
		
		System.out.println(new String(bt,0,len));
		/*int len = 0;
		
		while(-1 != (len = is.read(bt,0,bt.length))){
			System.out.println(new String(bt,0,len));
		}*/
		
		
		os.close();
		is.close();
		skt.close();
		
		
	}
	
}
