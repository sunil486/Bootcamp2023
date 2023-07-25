package com.sunil486.firstspringapp02.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
//@Profile(value = { "file", "database" })
@Profile(value = { "file", "database" })
public class Test {

}
