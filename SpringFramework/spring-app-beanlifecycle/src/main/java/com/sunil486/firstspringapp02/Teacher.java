package com.sunil486.firstspringapp02;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//@Component
public class Teacher implements InitializingBean, DisposableBean {

	private List<String> subjects;

	@PostConstruct()
	public void init() {
		System.out.println("init invoked");
		subjects = new ArrayList<>();
		subjects.add("CS");
		subjects.add("OOPS");
	}

	public void anotherInit() {
		System.out.println("anotherInit invoked");

	}

	public Teacher() {
		System.out.println("Teacher is initializing");
	}

	public void teach() {
		for (String subj : subjects) {
			System.out.println("Teaching " + subj);
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("#afterPropertiesSet() called");
		init();
	}

	// @PreDestroy
	public void destroy1() {
		System.out.println("destroy invoked");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("#destroy() called");
		destroy1();
	}

}
