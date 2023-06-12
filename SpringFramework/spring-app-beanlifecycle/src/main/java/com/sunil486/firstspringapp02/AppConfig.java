package com.sunil486.firstspringapp02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class AppConfig {

	//@Bean(initMethod = "anotherInit")
	//@Bean(destroyMethod = "destroy1")
	@Bean(initMethod = "anotherInit", destroyMethod = "destroy1")
	public Teacher teacher() {
		return new Teacher();
	}

}
