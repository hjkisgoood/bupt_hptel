package sjk.com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import sjk.com.demo.test.DatabaseInitializer;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        DatabaseInitializer initializer = context.getBean(DatabaseInitializer.class);
        initializer.createHotelTable();
    }
}