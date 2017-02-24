Learning Spring-Cloud
---

### Modules

- Eureka Server 服务注册中心


    spring-cloud-starter-eureka-server

- Eureka Client 服务提供者


    spring-cloud-starter-eureka

- Ribbon (Client Side Load Balancer) 负载均衡器


    spring-cloud-starter-ribbon
  
- Feign (Declarative REST Client)
    - include Ribbon
    - include Hystrix


    spring-cloud-starter-feign

- Circuit Breaker: Hystrix Clients 断路器


    spring-cloud-starter-hystrix

### Test

    - ribbon
    http localhost:3000/test-add
    - feign
    http localhost:3100/test-add

### Setup

> For IntelliJ setup, Enable annotation Processing should be checked.