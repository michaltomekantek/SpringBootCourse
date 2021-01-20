package com.course.rest.bootstrap;

import com.course.rest.domain.Beer;
import com.course.rest.repositories.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    @Autowired
    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObject();
    }

    private void loadBeerObject() {
        if(beerRepository.count() == 0){

            beerRepository.save(Beer.builder()
                    .beerName("Okocim")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .minOnHand(10)
                    .upc(33700001L)
                    .price(new BigDecimal(10))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Tyskie")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .minOnHand(10)
                    .upc(33700002L)
                    .price(new BigDecimal(10))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Warka")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .minOnHand(10)
                    .upc(33700003L)
                    .price(new BigDecimal(10))
                    .build());
        }
    }
}
