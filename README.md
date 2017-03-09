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

- Hystrix: (Circuit Breaker) 断路器


    spring-cloud-starter-hystrix

- Zuul: (Api Gateway) 服务网关


    spring-cloud-starter-zuul

### Annotations

- @SpringCloudApplication
    - @SpringBootApplication
    - @EnableDiscoveryClient
    - @EnableCircuitBreaker
- @EnableZuulProxy *spring-cloud-starter-zuul*

### Test

| Name                   | Port | Service         |
| ---                    | ---  | ---             |
| cloud-registry         | 8761 |                 |
| cloud-config           | 3900 | config-server   |
| cloud-gateway          | 8900 | api-gateway     |
| cloud-service-provider | 3000 |                 |
| client-ribbon          | 3100 | ribbon-consumer |
| client-feign           | 3200 | feign-consumer  |

    - ribbon
    http localhost:3000/test-add
    - feign
    http localhost:3100/test-add

### Setup

> For IntelliJ setup, Enable annotation Processing should be checked.