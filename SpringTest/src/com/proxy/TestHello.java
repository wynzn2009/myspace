package com.proxy;

public class TestHello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InHello hello = new Hello();
		HelloProxyHandler a = new HelloProxyHandler();
		InHello helloword = (InHello) a.bind(hello);
		helloword.saySomething();
		helloword.saySomething("HaHA");
	}

}
