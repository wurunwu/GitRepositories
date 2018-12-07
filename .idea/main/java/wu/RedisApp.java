package wu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)

public class RedisApp {
    public static void main(String[] args) {
        System.out.println("aa");
        SpringApplication.run(RedisApp.class,args);
    }
}
