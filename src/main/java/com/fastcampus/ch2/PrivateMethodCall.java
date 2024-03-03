package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {

	public static void main(String[] args) throws Exception{
//		Hello hello = new Hello();
//		hello.main(); // private라서 외부 호출이 불가능
		
		// Reflection API - Class info 얻고 다룰 수 있는 기능 제공
		// java.lang.reflect
		// Hello클래스의 Class객체(클래스의 정보를 담고 있는 객체)를 얻어온다.

		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		Hello hello = (Hello)helloClass.newInstance(); // Class 객체가 가진 정보로 객체 생성
		Method main = helloClass.getDeclaredMethod("main");
		main.setAccessible(true);
		
		main.invoke(hello); // hello.main 호출
	}

}
