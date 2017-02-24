Learning Spring-Cloud
---

### Modules

- Eureka Server 服务注册中心

        spring-cloud-starter-eureka-server

- Eureka Client 服务提供者

        spring-cloud-starter-eureka

- Ribbon (Client Side Load Balancer) 负载均衡器

        spring-cloud-starter-ribbon
  
- Feign (Declarative REST Client) include Ribbon

        spring-cloud-starter-feign


### Test

    - ribbon
    http localhost:3000/test-add
    - feign
    http localhost:3100/test-add

### Setup

> For IntelliJ setup, Enable annotation Processing should be checked.