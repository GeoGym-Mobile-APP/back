package ma.fstm.ilisi.routage.shorthpath;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "ma.fstm.ilisi.routage.shorthpath.model.bo")
@EnableJpaRepositories(basePackages = "ma.fstm.ilisi.routage.shorthpath.model.dao")
@SpringBootApplication
public class ShorthPathApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShorthPathApplication.class, args);
    }

}
