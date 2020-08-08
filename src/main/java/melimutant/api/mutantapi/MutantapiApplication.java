package melimutant.api.mutantapi;


import melimutant.api.repository.ResultDnaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

@EntityScan("melimutant.api.mutantapi.entity")
@EnableJpaRepositories("melimutant.api.repository")
@SpringBootApplication
@RestController
public class MutantapiApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(MutantapiApplication.class);

    @Autowired
    private ResultDnaRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(MutantapiApplication.class, args);
    }

   

    @Override
    public void run(String... args) {

        log.info("StartApplication...");
       

    }
}
