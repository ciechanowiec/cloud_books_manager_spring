package eu.ciechanowiec.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tinylog.Logger;

/**
 * @author Herman Ciechanowiec
 */
@SpringBootApplication
class Main {

    public static void main(String[] args) {
        Logger.info("Application started.");
        SpringApplication.run(Main.class, args);
    }
}		
