package com.noah.socket.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TelnetServer {

	public static void main(String[] args) {

		try (ServerSocket s = new ServerSocket(8888)) {
			try(Socket so = s.accept()){
				InputStream is = so.getInputStream();
				OutputStream os = so.getOutputStream();
				
				try(Scanner scan = new Scanner(is)){
					
					PrintWriter out = new PrintWriter(os,true);
					
					out.println("Hello,Enter Bye to exit;");
					
					boolean done = false;
					
					while (!done && scan.hasNextLine()) {
						String line = scan.nextLine();
						out.println("Telnet:" + line);
						if (line.trim().toLowerCase().equals("bye")) {
							done = true;
						}
					}
					
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
