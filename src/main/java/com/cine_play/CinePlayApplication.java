package com.cine_play;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;

@SpringBootApplication
public class CinePlayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinePlayApplication.class, args);
	}

	// --- BLOQUE DE DIAGNÓSTICO INTEGRADO ---
	@Bean
	public CommandLineRunner printDiagnosticInfo(ConfigurableEnvironment env) {
		return args -> {
			System.out.println("\n\n\n--- DIAGNÓSTICO DE PROPIEDADES ---");
			System.out.println("==========================================");

			String url = env.getProperty("spring.datasource.url");
			String username = env.getProperty("spring.datasource.username");

			System.out.println("URL de la base de datos que Spring está usando: '" + url + "'");
			System.out.println("Username que Spring está usando: '" + username + "'");

			System.out.println("\nBuscando el origen de la propiedad 'spring.datasource.username'...");
			for (PropertySource<?> propertySource : env.getPropertySources()) {
				if (propertySource.containsProperty("spring.datasource.username")) {
					System.out.println("-> Propiedad encontrada en la fuente: '" + propertySource.getName() + "'");
					break; // Nos detenemos en la primera (la de mayor prioridad)
				}
			}
			System.out.println("==========================================");
			System.out.println("-- FIN DEL DIAGNÓSTICO --\n\n\n");
		};
	}
	// --- FIN DEL BLOQUE ---
}