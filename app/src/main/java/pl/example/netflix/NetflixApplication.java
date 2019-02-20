package pl.example.netflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@EnableAutoConfiguration
@ComponentScan
public class NetflixApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetflixApplication.class, args);
    }
}
