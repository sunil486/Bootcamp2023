package com.sunil486.firstspringapp02;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

@Component
public class Greet implements MessageSourceAware {

	@Override
	public void setMessageSource(MessageSource messageSource) {
		System.out.println("##MessageSourceAware setMessageSource() method");

		// String message = messageSource.getMessage("greet", null, Locale.US);
		String message = messageSource.getMessage("greet", null, Locale.FRANCE);

		// Need to check , not working
		// String message = messageSource.getMessage("greet", null, Locale.of("hi",
		// "India"));
		System.out.println(message);
	}

}
