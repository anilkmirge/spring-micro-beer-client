package next.monster.springmicrobeerclient.web.client;

import next.monster.springmicrobeerclient.web.model.BeerDto;
import next.monster.springmicrobeerclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "next.monster", ignoreUnknownFields = false)

public class BeerClient {

    public final String BEER_PATH_V1="/api/v1/beer/";
    public final String CUSTOMER_PATH_V1="/api/v1/customer/";
    private final RestTemplate restTemplate;
    private String apihost;

    public BeerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID uuid) {
        return restTemplate.getForObject(apihost + BEER_PATH_V1 + uuid.toString(), BeerDto.class);
    }

    public URI saveNewBeer(BeerDto beerDto){
        return restTemplate.postForLocation(apihost + BEER_PATH_V1, beerDto);
    }

    public void updateBeer(UUID id, BeerDto beerDto) {
        restTemplate.put(apihost + BEER_PATH_V1 + id.toString(), beerDto);
    }

    public void deleteBeer(UUID id) {
        restTemplate.delete(apihost + BEER_PATH_V1 + id);
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

    public CustomerDto getCustomerById(UUID customerId) {
        return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + customerId.toString(), CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customer) {
        return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, customer);
    }

    public void updateCustomer(UUID customerId, CustomerDto customer) {
        restTemplate.put(apihost + CUSTOMER_PATH_V1 + customerId.toString(), customer);
    }

    public void deleteCustomer(UUID customerId) {
        restTemplate.delete(apihost + CUSTOMER_PATH_V1 + customerId);
    }
}
