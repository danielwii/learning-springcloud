package client.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author daniel
 * @since 24/02/2017
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class Application {

    @Resource
    private ComputeClient computeClient;

    @RequestMapping("/test-add")
    public Integer testAdd() {
        return computeClient.add(10, 20);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

@Component
class ComputeClientHystrix implements ComputeClient {

    @Override
    public Integer add(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        return -999_999_999;
    }
}

@FeignClient(value = "compute-service", fallback = ComputeClientHystrix.class)
interface ComputeClient {

    @RequestMapping("/add")
    Integer add(@RequestParam("a") Integer a, @RequestParam("b") Integer b);

}
