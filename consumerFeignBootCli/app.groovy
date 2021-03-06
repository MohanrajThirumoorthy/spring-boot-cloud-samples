package producer
	
@Grab("org.springframework.cloud:spring-cloud-starter-feign:1.0.0.RELEASE")
@Grab("org.springframework.cloud:spring-cloud-starter-eureka:1.0.0.RELEASE")
//@Grab("org.springframework.cloud:spring-cloud-netflix-core:1.0.0.RELEASE")
@Grab("org.springframework.cloud:spring-cloud-netflix:1.0.0.RELEASE")

@Grab("com.netflix.feign:feign-core:6.1.3")
@Grab("com.netflix.feign:feign-gson:6.1.3")

import org.springframework.cloud.netflix.feign.FeignClient

import org.springframework.cloud.netflix.feign.FeignClientScan

@EnableDiscoveryClient
@FeignClientScan
@RestController
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

  @Autowired
  ProducerClient client

  @RequestMapping("/")
  String consume() {
    ProducerResponse response = client.getValue()

    "{\"value\": ${response.value}}"
  }
}

@FeignClient("producer")
public interface ProducerClient {
  @RequestMapping(method = RequestMethod.GET, value = "/")
  ProducerResponse getValue()
}

public class ProducerResponse {
  Integer value
}
