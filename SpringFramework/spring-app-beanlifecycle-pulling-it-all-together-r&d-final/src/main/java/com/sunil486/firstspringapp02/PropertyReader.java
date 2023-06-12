package com.sunil486.firstspringapp02;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class PropertyReader implements EnvironmentAware {

	// @Autowired
	Environment env;

	public void readProperty() {
		System.out.println(env.getProperty("name"));
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.env = environment;

	}

}
