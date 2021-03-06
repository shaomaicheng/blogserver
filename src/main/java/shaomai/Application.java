package shaomai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import shaomai.exception.ArtSelectException;
import shaomai.exception.ExceptionManager;
import shaomai.exception.NumberIllegalException;
import shaomai.exception.TokenException;

import static shaomai.exception.Code.ART_SELECT_ERROR_CODE;
import static shaomai.exception.Code.NUMBER_ILLEGAL_ERROR_CODE;
import static shaomai.exception.Code.TOKEN_INVALIED;

@SpringBootApplication
public class Application {

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }

    public static void main(String[] args) {

        registerException();

        SpringApplication.run(Application.class, args);

    }

    private static void registerException() {
        ExceptionManager.registerException(ArtSelectException.class, ART_SELECT_ERROR_CODE);
        ExceptionManager.registerException(NumberIllegalException.class, NUMBER_ILLEGAL_ERROR_CODE);
        ExceptionManager.registerException(TokenException.class, TOKEN_INVALIED);
    }
}
