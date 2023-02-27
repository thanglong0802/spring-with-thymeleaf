package com.nf.springboot;

import com.nf.springboot.model.Girl;
import com.nf.springboot.service.GirlService;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
//		ApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);
//		GirlService girlService = context.getBean(GirlService.class);
//		Girl girl = girlService.getRandomGirl();
//		Girl girl1 = girlService.getRandomGirl();
//
//		System.out.println(girl);
//		System.out.println(girl1);
	}

}
