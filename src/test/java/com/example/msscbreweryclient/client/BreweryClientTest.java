package com.example.msscbreweryclient.client;

import com.example.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        final BeerDto dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void testSaveNewBeer() {
        BeerDto beerDto = BeerDto.builder().beerName("New Beer Name").build();
        URI uri = client.saveNewBeer(beerDto);
        assertNotNull(uri);
    }

    @Test
    void testUpdateBeerDto() {
        BeerDto beerDto = BeerDto.builder().id(UUID.randomUUID()).beerName("New Beer").build();
        client.updateBeer(beerDto.getId(), beerDto);
    }

    @Test
    void testDeleteBeerDto() {
        BeerDto beerDto = BeerDto.builder().id(UUID.randomUUID()).beerName("New Beer").build();
        client.deleteBeer(beerDto.getId());
    }
}
