package com.carambolos.bolos;

import io.github.cdimascio.dotenv.Dotenv;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@OpenAPIDefinition(
		info = @Info(
				title = "API Bolos - Carambolos",
				version = "v1",
				description = "Microserviço de Bolos, Massas, Coberturas e Recheios"
		),
		servers = {
				@Server(url = "http://localhost:8082", description = "Servidor Local")
		}
)
@SpringBootApplication
@EnableFeignClients
public class BolosServiceApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure()
				.filename("dev.env")
				.ignoreIfMissing()
				.load();

		System.setProperty("spring.datasource.username", dotenv.get("DB_USERNAME"));
		System.setProperty("spring.datasource.password", dotenv.get("DB_PASSWORD"));
		System.setProperty("spring.datasource.url", dotenv.get("DB_URL"));

		SpringApplication.run(BolosServiceApplication.class, args);
	}
}