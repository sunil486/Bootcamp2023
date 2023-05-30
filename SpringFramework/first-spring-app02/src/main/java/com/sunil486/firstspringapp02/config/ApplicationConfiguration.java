package com.sunil486.firstspringapp02.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.sunil486.firstspringapp02.Mobile;
import com.sunil486.firstspringapp02.Sim;

//@ComponentScan ==> will scan only current package(i.e com.sunil486.firstspringapp02.config)
// and its subpackage
//@ComponentScan("com.sunil486.firstspringapp02")
// To scan multiple packages
@ComponentScan(basePackages = { "com.sunil486.firstspringapp02" })
public class ApplicationConfiguration {

//	// Using setter injection
//	// Here default bean name is method name i.e createMobileBean
//	@Bean("mobile")
//	public Mobile createMobileBean(@Autowired @Qualifier("airtel") Sim sim) {
//
//		Mobile mobile = new Mobile();
//		mobile.setSim(sim);
//		return mobile;
//	}

	// Using constructor injection
	// Here default bean name is method name i.e createMobileBea
	// Here Mobile class constructor needs to be created then only it will work
//	@Bean("mobile")
//	public Mobile createMobileBean(@Autowired @Qualifier("jio") Sim sim) {
//
//		return new Mobile(sim);
//	}

	// Without @Autowired annotation also, it will work
	@Bean("mobile")
	public Mobile createMobileBean(@Qualifier("jio") Sim sim) {

		return new Mobile(sim);
	}

}
