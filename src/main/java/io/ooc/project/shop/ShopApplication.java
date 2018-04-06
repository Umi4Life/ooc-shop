package io.ooc.project.shop;

import io.ooc.project.shop.model.User;
import io.ooc.project.shop.repository.UserRepository;
import io.ooc.project.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.beans.beancontext.BeanContext;

@SpringBootApplication
public class ShopApplication {
    @Autowired
    private static UserRepository userRepository;

    @Autowired
    private static UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

	@Bean
    public WebMvcConfigurer configurer(){
	    return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/item/*").allowedOrigins("http://localhost:8081");
            }
        };


    }
}
