package lab.Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/** not Eight */
@SpringBootApplication
public class Ate {
    public static void main(String[] args) {
        SpringApplication.run(Ate.class, args);
    }
}
