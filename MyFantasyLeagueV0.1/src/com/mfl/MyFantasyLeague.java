package com.mfl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ImportResource;


@ImportResource({ "classpath:hibernate5Config.xml" })
@EntityScan(basePackages = {"com.mfl.models"})
@SpringBootApplication
public class MyFantasyLeague {
	
	
	public static void main(String[] args) {
	
		SpringApplication.run(MyFantasyLeague.class,args);
	}

}
