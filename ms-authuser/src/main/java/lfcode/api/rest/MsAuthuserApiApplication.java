package lfcode.api.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@EnableCaching
@SpringBootApplication
public class MsAuthuserApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAuthuserApiApplication.class, args);
		//System.out.println(new BCryptPasswordEncoder().encode("197197")); //gerando senha cryptografada de teste
	}

}
