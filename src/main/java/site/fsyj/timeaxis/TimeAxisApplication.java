package site.fsyj.timeaxis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
<<<<<<< HEAD
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
=======

>>>>>>> 961dc4a4990572e3a9cec04845f0e86cf539dac8
@SpringBootApplication
public class TimeAxisApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TimeAxisApplication.class, args);
    }

}
