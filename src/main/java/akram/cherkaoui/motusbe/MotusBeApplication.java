package akram.cherkaoui.motusbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class MotusBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MotusBeApplication.class, args);
    }

}
