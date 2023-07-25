package com.sunil486.firstspringapp02;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class AppConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	// Both will work fine
	// public Film film(Actor actor) {
	// public Film film(@Autowired Actor actor) {

	// To resolve multiple bean issue, use @Qualifier
	// public Film film(@Autowired @Qualifier("kingkhan") Actor actor) {
	// public Film film(@Autowired @Qualifier("mahesh") Actor actor) {
	// public Film film(@Autowired @Qualifier("babu") Actor actor) {
	// public Film film(@Autowired @Qualifier("kingkohali") Actor actor) {

	// To resolve multiple bean issue, without using @Qualifier, we can make one
	// bean as primary
	// using @Primary
	// public Film film(@Autowired Actor actor) {

	// return new Film(actor);
	// }

	// To resolve multiple bean issue, neither using @Qualifier or @Primary
	// public Film film(@Autowired Actor babu) {

	// return new Film(babu);
	// }

	// If we don't want beans to be eligible for autowiring then use
	// autowireCandidate=false else true
	public Film film(@Autowired Actor actor) {

		return new Film(actor);
	}

	// @Primary
	@Bean(name = "kingkhan")
	public SRK srk() {
		return new SRK();
	}

	@Bean(autowireCandidate = false, name = { "mahesh", "babu" })
	public MaheshBabu maheshBabu() {
		return new MaheshBabu();
	}

	@Bean(autowireCandidate = false, value = "kingkohali")
	public KK kk() {
		return new KK();
	}

}
