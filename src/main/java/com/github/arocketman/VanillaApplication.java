package com.github.arocketman;

import com.github.arocketman.entities.Role;
import com.github.arocketman.entities.User;
import com.github.arocketman.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication  //(exclude = ElasticsearchDataAutoConfiguration.class)
public class VanillaApplication {
    

    @Bean
    public CommandLineRunner setupDefaultUser(UserService service) {
        return args -> {
            service.save(new User(
                    "admin", //username
                    "pass", //password
Arrays.asList(new Role("USER"), new Role("ACTUATOR")),//roles 
                    true//Active
            ));
        };
    }
    
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }    

    public static void main(String[] args) {
        SpringApplication.run(VanillaApplication.class, args);
    }

}

