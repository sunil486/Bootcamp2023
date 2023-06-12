package com.sunil486.firstspringapp02;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Player implements BeanNameAware, ApplicationContextAware {

	private ApplicationContext context;

	// I need to initialize game without using @Autowired, constructor or setter
	// injection
	// For this we have to use ApplicationContextAware to achieve above scenario
	private Game game;

	public Player() {
		System.out.println("Player is initializing..");
	}

	public void play() {
		game = context.getBean("game", Game.class);
		game.startGame();

	}

	// callback method ==> Automatically called by spring framework
	@Override
	public void setBeanName(String name) {
		System.out.println("##BeanNameAware setBeanName() method");
		// System.out.println("Bean name is : " + name);

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("##ApplicationContextAware setApplicationContext() method");
		context = applicationContext;
	}

}
