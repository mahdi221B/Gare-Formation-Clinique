package tn.esprit.spring.testspring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.persistence.GeneratedValue;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Slf4j
@EnableScheduling
@SpringBootApplication
@EntityScan(basePackages = {"tn.esprit.spring.entity"})
@ComponentScan(basePackages = {"tn.esprit.spring.controllers","tn.esprit.spring.services"})
@EnableJpaRepositories(basePackages = {"tn.esprit.spring.repositories"})
public class TestSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestSpringApplication.class, args);
    }

}
