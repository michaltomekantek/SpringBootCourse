package com.course.rest.services.v2;

import com.course.rest.web.model.v2.BeerDTOV2;

import java.util.UUID;

public interface BeerServiceV2 {
    BeerDTOV2 getBeerById(UUID beerId);
    BeerDTOV2 saveBeer(BeerDTOV2 beerDTO);
    void updateBeer(UUID beerId, BeerDTOV2 beerDTO);
    void deleteBeer(UUID beerId);
}
