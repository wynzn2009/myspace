package com.proxy;

public class Hello implements InHello {

	@Override
	public void saySomething() {
		// TODO Auto-generated method stub
		System.out.println("I am function one!");
	}

	@Override
	public void saySomething(String word) {
		// TODO Auto-generated method stub
		System.out.println("I am what i am!"+word);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
