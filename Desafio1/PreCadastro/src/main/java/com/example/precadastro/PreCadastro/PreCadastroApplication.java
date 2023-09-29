package com.example.precadastro.PreCadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories("com.example.precadastro.PreCadastro.*")
@ComponentScan(basePackages = {"com.example.precadastro.PreCadastro.*"})
@EntityScan("com.example.precadastro.PreCadastro.*")
@SpringBootApplication
public class PreCadastroApplication {

    public static void main(String[] args) {
        SpringApplication.run(PreCadastroApplication.class, args);
    }

}
