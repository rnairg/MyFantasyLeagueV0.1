package com.mfl;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mfl.utils.CommonUtilities;

public class MyFantasyLeague {
	
	public enum choice {a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		String c ="a";
		ApplicationContext context;
		EnumMap<choice, String> map = new EnumMap<choice, String>(choice.class);
		map.put(choice.a, "Submit a Team");
		map.put(choice.b, "View Teams");
		map.put(choice.c, "Update Teams");
		map.put(choice.d, "Delete Teams");
		
		map.put(choice.e, "Add a Player");
		map.put(choice.f, "View Players");
		map.put(choice.g, "Update Players");
		map.put(choice.h, "Delete Players");
		
		map.put(choice.i, "Add a Match");
		map.put(choice.j, "View Matches");
		map.put(choice.k, "Update Matches");
		map.put(choice.l, "Delete Matches");
		
		map.put(choice.m, "Submit a IPL Team");
		map.put(choice.n, "View IPL Teams");
		map.put(choice.o, "Update IPL Teams");
		map.put(choice.p, "Delete IPL Teams");
		
		CommonUtilities.displayMenu();
		
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
