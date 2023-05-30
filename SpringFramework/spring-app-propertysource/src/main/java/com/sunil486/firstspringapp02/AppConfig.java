package com.sunil486.firstspringapp02;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@ComponentScan(basePackages = { "com.sunil486.firstspringapp02" })
//Way1
//@PropertySource(value = "classpath:app.properties")
//@PropertySource(value = "file:/Users/sunilkumargupta/WorkingDirectory/Bootcamp2023/SpringFramework/abc/myapp.properties")

//Way2
@PropertySources(value = { 
		@PropertySource(value = "classpath:app.properties"),
		@PropertySource(value = "file:/Users/sunilkumargupta/WorkingDirectory/Bootcamp2023/SpringFramework/abc/myapp.properties") })
public class AppConfig {

}
