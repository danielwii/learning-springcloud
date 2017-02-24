package client.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author daniel
 * @since 24/02/2017
 */
@EnableDiscoveryClient
@EnableCircuitBreaker
@SpringBootApplication
@RestController
public class Application {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Resource
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping("/test-add")
    public String testAdd() {
        return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=10&b=20", String.class).getBody();
    }

    public String fallback() {
        return "ERROR by CircuitBreaker >______,.<";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
