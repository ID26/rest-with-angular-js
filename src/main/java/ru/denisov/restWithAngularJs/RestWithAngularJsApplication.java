package ru.denisov.restWithAngularJs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class RestWithAngularJsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestWithAngularJsApplication.class, args);
	}

}
