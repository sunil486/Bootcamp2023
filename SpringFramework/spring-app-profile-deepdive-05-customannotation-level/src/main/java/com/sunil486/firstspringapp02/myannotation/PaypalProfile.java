package com.sunil486.firstspringapp02.myannotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.context.annotation.Profile;

@Profile("paypal")
@Retention(RetentionPolicy.RUNTIME)
public @interface PaypalProfile {

}
