package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Remote_Call
public class Hello {
	
	int iv = 10;
	static int cv = 20; 
	
	@RequestMapping("/hello")
	private void main() {
		System.out.println("Hello - Static");
		System.out.println(iv + " , " + cv); // OK
	}
	
	public static void main2() {
		System.out.println(cv); // OK
//		System.out.println(iv); // Error
	}

}
