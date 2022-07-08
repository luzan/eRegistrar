package edu.miu.cs.cs425.eregistar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ERegistarApplication {

    public static void main(String[] args) {
        SpringApplication.run(ERegistarApplication.class, args);
    }

}
