package net.mvanm.characterservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String args[]) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        // Integenstelling tot wat de documentatie beweerd, werkt forceren op reactive niet goed. Tomcat wordt gewoon weer
        // opgestart als starter-web ook is opgenomen in de pom. We zien echter wat inconsequent gedrag daarom adviseer
        // ik deze soms op servlet te zetten. Dan weet je zeker dat netty niet toch geladen wordt
        springApplication.setWebApplicationType(WebApplicationType.REACTIVE);
        // Indien we webflux niet geladen hebben dan werkt .REACTIVE ook niet, maar ik vertrouw niet erop dat REACTIVE altijd goed werkt
        springApplication.run(args);
    }
}
