package br.com.simulaprefeitura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
public class SimulaprefeituraApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimulaprefeituraApplication.class, args);
	}

}
