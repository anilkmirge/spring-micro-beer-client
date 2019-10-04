package next.monster.springmicrobeerclient.web.client;

import next.monster.springmicrobeerclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerClientTest {

    @Autowired
    BeerClient client;

    @Test
    void getBeerById() {
        BeerDto beer = client.getBeerById(UUID.randomUUID());
        assertNotNull(beer);
    }
}