package com.course.rest.services.v2;

import com.course.rest.web.model.v2.BeerDTOV2;
import com.course.rest.web.model.v2.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Slf4j
@Service
public class BeerServiceImplV2 implements BeerServiceV2 {

    @Override
    public BeerDTOV2 getBeerById(UUID beerId) {
        return BeerDTOV2.builder()
                .id(beerId)
                .beerName("OKOCIM")
                .beerStyle(BeerStyleEnum.IPA)
                .build();
    }

    @Override
    public BeerDTOV2 saveBeer(BeerDTOV2 BeerDTOV2) {
        return BeerDTOV2;
    }

    @Override
    public void updateBeer(UUID beerId, BeerDTOV2 BeerDTOV2) {

    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.debug("Remove beer");
    }
}
