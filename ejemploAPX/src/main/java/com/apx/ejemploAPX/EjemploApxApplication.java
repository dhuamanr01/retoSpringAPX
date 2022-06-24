package com.apx.ejemploAPX;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;



@SpringBootApplication
@ImportResource("classpath:/beans.xml")
public class EjemploApxApplication {


	public static void main(String[] args) {
		SpringApplication.run(EjemploApxApplication.class, args);
		

        
	}

}
