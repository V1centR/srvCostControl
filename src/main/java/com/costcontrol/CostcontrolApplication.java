package com.costcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(scanBasePackages = {"com.costcontrol"})
@ComponentScan(basePackages = "com.*")
@EntityScan("com.costcontrol.entities")
public class CostcontrolApplication {

	public static void main(String[] args) {
		SpringApplication.run(CostcontrolApplication.class, args);
	}

}
