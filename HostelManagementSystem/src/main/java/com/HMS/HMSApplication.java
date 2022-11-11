package com.HMS;
/* Main application of hostel management system project
 * which is designed by swagger ui and jwt and security
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HMSApplication {

	public static void main(String[] args) {
		SpringApplication.run(HMSApplication.class, args);
	}

}
