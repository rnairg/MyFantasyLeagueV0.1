package com.mfl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@ImportResource({ "classpath:hibernate5Config.xml" })
@SpringBootApplication
public class MyFantasyLeague {
	
	
	public static void main(String[] args) {
	
		SpringApplication.run(MyFantasyLeague.class,args);
	}

}
