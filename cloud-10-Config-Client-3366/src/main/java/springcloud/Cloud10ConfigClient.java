package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 程世玉
 * @data 2022/5/4.
 */
@SpringBootApplication
@EnableEurekaClient
public class Cloud10ConfigClient {
    public static void main(String[] args) {
        SpringApplication.run(Cloud10ConfigClient.class,args);
    }
}
