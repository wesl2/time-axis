package site.fsyj.timeaxis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TimeAxisApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TimeAxisApplication.class, args);
    }

}
