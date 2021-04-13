package com.utm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@EnableEncryptableProperties
@SpringBootApplication
public class SpringBootSigninSignupExampleApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/UTM");
		SpringApplication.run(SpringBootSigninSignupExampleApplication.class, args);
	}

}
