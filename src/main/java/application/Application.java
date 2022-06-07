package application;

/*pacotes para o funcionamento do project*/

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

/* instanciação do método main (principal) com a marcação do framework*/

@SpringBootApplication
public class Application{
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
    
}