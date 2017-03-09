package cloud.provider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author daniel
 * @since 24/02/2017
 */
@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class Application {

    @Resource
    private DiscoveryClient client;

    @RequestMapping("/add")
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance _instance = client.getLocalServiceInstance();
        Integer         _result   = a + b;
        log.info("/add, host: {}, service_id: {}, result: ", _instance.getHost(), _instance.getServiceId(), _result);
        return _result;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
