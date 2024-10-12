package gps.gestion.de.proyectos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping; // Import necesario
import org.springframework.web.bind.annotation.RequestParam; // Import necesario
import org.springframework.web.bind.annotation.RestController; // Import necesario

@SpringBootApplication
@RestController // Agregar esta anotación para que la clase sea un controlador REST
public class GestionDeProyectosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionDeProyectosApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "si") String name) {
		return String.format("Hello %s!", name);
	}
}
