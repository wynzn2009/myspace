package com.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketTest {
	public void testSocked() throws IOException, IOException{
		String host = "";
		Integer port = 80;
		Socket s = new Socket(host,port);
		s.setSoTimeout(10000);
		s.connect(new InetSocketAddress(host,port),10000);
		
		
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
//		try(Socket s = new Socket("time-A.timefreq.bldrdoc.gov",13)){
//			InputStream inStream = s.getInputStream();
//			@SuppressWarnings("resource")
//			Scanner in = new Scanner(inStream);
//			while(in.hasNextLine()){
//				String line = in.nextLine();
//				System.out.println(line);
//			}
//		}
		InetAddress[] add = InetAddress.getAllByName("www.baidu.com");
		for(InetAddress a : add){
			System.out.println(a);
		}
	}
}
