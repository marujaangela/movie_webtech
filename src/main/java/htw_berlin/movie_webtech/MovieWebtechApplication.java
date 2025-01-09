package htw_berlin.movie_webtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("htw_berlin.movie_webtech.persistence")
public class MovieWebtechApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieWebtechApplication.class, args);
	}

}
