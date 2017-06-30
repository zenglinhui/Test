package com.noah.socket.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	
	
	public static void main(String[] args) throws UnknownHostException {
		
		if(args.length > 0){
			
			InetAddress[] address = InetAddress.getAllByName(args[0]);
			for (int i = 0; i < address.length; i++) {
				System.out.println(address[i]);
			}
			
		}else {
			InetAddress address = InetAddress.getLocalHost();
			InetAddress address2 = InetAddress.getLoopbackAddress();
			System.out.println(address);
			System.out.println(address2);
		}
		
	}

}
