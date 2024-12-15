package proyectofinal.proyectofinal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.security.Key;

import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import proyectofinal.proyectofinal.Categoria.CategoriaService;
import proyectofinal.proyectofinal.Grado.GradoService;
import proyectofinal.proyectofinal.Nivel.NivelService;
import proyectofinal.proyectofinal.aula.AulaService;
import proyectofinal.proyectofinal.Categoria.CategoriaRequest;
import proyectofinal.proyectofinal.Grado.GradoRequest;
import proyectofinal.proyectofinal.Nivel.NivelRequest;
import proyectofinal.proyectofinal.aula.AulaRequest;

@SpringBootApplication
public class ProyectofinalApplication implements CommandLineRunner {

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private GradoService gradoService;

	@Autowired
	private NivelService nivelService;

	@Autowired
	private AulaService aulaService;

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure()
				.directory(System.getProperty("user.dir"))
				.load();
		System.setProperty("SPRING_DATASOURCE_URL",
				dotenv.get("SPRING_DATASOURCE_URL"));
		System.setProperty("SPRING_DATASOURCE_USERNAME",
				dotenv.get("SPRING_DATASOURCE_USERNAME"));
		System.setProperty("SPRING_DATASOURCE_PASSWORD",
				dotenv.get("SPRING_DATASOURCE_PASSWORD"));
		System.setProperty("JWT_SECRET", dotenv.get("JWT_SECRET")); // Añadir esta línea

		SpringApplication.run(ProyectofinalApplication.class, args);
		Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // o HS512, HS384
		String base64Key = Encoders.BASE64.encode(key.getEncoded());
		System.out.println(base64Key);
	}

	@Override
	public void run(String... args) throws Exception {
		// Insertar datos en la tabla Categoria si está vacía
		if (categoriaService.findAll().isEmpty()) {
			categoriaService.createCategoria(new CategoriaRequest("Matemáticas"));
			categoriaService.createCategoria(new CategoriaRequest("Ciencias"));
			categoriaService.createCategoria(new CategoriaRequest("Lenguaje"));
			categoriaService.createCategoria(new CategoriaRequest("Historia"));
		}

		// Insertar datos en la tabla Grado si está vacía
		if (gradoService.findAll().isEmpty()) {
			gradoService.save(new GradoRequest("Primero de Primaria"));
			gradoService.save(new GradoRequest("Segundo de Primaria"));
			gradoService.save(new GradoRequest("Tercero de Primaria"));
			gradoService.save(new GradoRequest("Cuarto de Primaria"));
			gradoService.save(new GradoRequest("Quinto de Primaria"));
			gradoService.save(new GradoRequest("Sexto de Primaria"));
		}

		// Insertar datos en la tabla Nivel si está vacía
		if (nivelService.getAllNiveles().isEmpty()) {
			nivelService.saveNivel(new NivelRequest("Inicial"));
			nivelService.saveNivel(new NivelRequest("Primaria"));
			nivelService.saveNivel(new NivelRequest("Secundaria"));
		}

		// Insertar datos en la tabla Aula si está vacía
		if (aulaService.findAll().isEmpty()) {
			aulaService.createAula(new AulaRequest(20, 30, "Disponible"));
			aulaService.createAula(new AulaRequest(25, 35, "Disponible"));
			aulaService.createAula(new AulaRequest(30, 40, "Disponible"));
		}
	}
}