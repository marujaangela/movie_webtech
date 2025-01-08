package htw_berlin.movie_webtech.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(final CorsRegistry registry) {
        registry
                .addMapping("/**") // Erlaubt CORS für alle Routen
                .allowedMethods("*") // Erlaubt alle HTTP-Methoden
                .allowedOrigins(
                        "http://localhost:5173", // Lokale Entwicklungsumgebung
                        "https://movie-webtech-frontend.onrender.com" // Gehostetes Frontend
                )
                .allowedHeaders("*") // Erlaubt alle Header
                .allowCredentials(true); // Erlaubt das Senden von Cookies und Authentifizierungsinformationen
    }
}
