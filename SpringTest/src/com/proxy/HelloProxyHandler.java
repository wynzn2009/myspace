package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class HelloProxyHandler implements InvocationHandler {
	private Object ob;
	public Object bind(Object ob){
		this.ob = ob;
		return Proxy.newProxyInstance(this.ob.getClass().getClassLoader(), this.ob.getClass().getInterfaces(), this);
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		Object result = null;
		try{
			System.out.println("Before is OK!");
			result = method.invoke(this.ob, args);
			System.out.println("After is OK!");
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
