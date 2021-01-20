package com.course.rest.services;

import com.course.rest.web.model.BeerDTO;

import java.util.UUID;

public interface BeerService {
    BeerDTO getBeerById(UUID beerId);
    BeerDTO saveBeer(BeerDTO beerDTO);
    BeerDTO updateBeer(UUID beerId, BeerDTO beerDTO);
    void deleteBeer(UUID beerId);
}
