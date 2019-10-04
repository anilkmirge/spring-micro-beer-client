package next.monster.springmicrobeerclient.web.client;

import next.monster.springmicrobeerclient.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
@ConfigurationProperties(value = "next.monster", ignoreUnknownFields = false)
public class BeerClient {

    public final String BEER_PATH_V1="/api/v1/beer/";
    private String apihost;
    private final RestTemplate restTemplate;

    public BeerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID uuid) {
        return restTemplate.getForObject(apihost + BEER_PATH_V1 + uuid.toString(), BeerDto.class);
    }
    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}
