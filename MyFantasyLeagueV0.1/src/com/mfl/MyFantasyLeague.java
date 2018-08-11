package com.mfl;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mfl.utils.CommonUtilities;

public class MyFantasyLeague {
	
	public enum choice {a,b,c,d};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		String c ="a";
		ApplicationContext context;
		EnumMap<choice, String> map = new EnumMap<choice, String>(choice.class);
		map.put(choice.a, "Submit a Team");
		map.put(choice.b, "Submit a Prediction");
		map.put(choice.c, "Enter a Player");
		map.put(choice.d, "create New Rule");
		
		System.out.println("What would you like to do:\n");
		System.out.println("a. Submit a Team\n");
		System.out.println("b. Submit a Prediction\n");
		System.out.println("c. Enter a Player\n");
		System.out.println("d. create New Rule\n");
		
		Scanner sc = new Scanner(System.in);
		
		do {
			c = sc.next();
			if(CommonUtilities.isInEnum(c,choice.class)) {
			context = new ClassPathXmlApplicationContext("MFL.xml");
			RequestHandlers req = (RequestHandlers) context.getBean("requesthandlers");
			req.handleRequest(map.get(choice.valueOf(c)));
			}
		}
		while (CommonUtilities.isInEnum(c,choice.class));
		sc.close();
				
		System.out.println("Bye Bye");
	
	}

}
