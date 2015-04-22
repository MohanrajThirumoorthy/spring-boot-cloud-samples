import org.springframework.web.client.RestTemplate
import org.springframework.cloud.client.ServiceInstance
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;

@EnableDiscoveryClient
@RestController
public class Application {

  @Autowired
  DiscoveryClient discoveryClient

  @RequestMapping("/")
  String consume() {
    InstanceInfo instance = discoveryClient.getNextServerFromEureka("PRODUCER", false)

    RestTemplate restTemplate = new RestTemplate()
    ProducerResponse response = restTemplate.getForObject(instance.homePageUrl, ProducerResponse.class)

    "{\"value\": ${response.value}}\n"
  }
}

public class ProducerResponse {	
  Integer value
}
