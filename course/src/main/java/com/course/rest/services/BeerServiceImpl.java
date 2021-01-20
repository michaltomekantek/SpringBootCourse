package com.course.rest.services;

import com.course.rest.domain.Beer;
import com.course.rest.repositories.BeerRepository;
import com.course.rest.services.exceptions.NotFoundException;
import com.course.rest.web.mappers.BeerMapper;
import com.course.rest.web.model.BeerDTO;
import com.course.rest.web.model.BeerStyleEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {
    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDTO getBeerById(UUID beerId) {
        return beerMapper.beerToBeerDTO(beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
    }

    @Override
    public BeerDTO saveBeer(BeerDTO beerDTO) {
       return beerMapper.beerToBeerDTO(beerRepository.save(beerMapper.beerDTOToBeer(beerDTO)));
    }

    @Override
    public BeerDTO updateBeer(UUID beerId, BeerDTO beerDTO) {
        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);
        beer.setBeerName(beerDTO.getBeerName());
        beer.setBeerStyle(beerDTO.getBeerStyle().name());
        beer.setPrice(beerDTO.getPrice());

        return beerMapper.beerToBeerDTO(beerRepository.save(beer));
    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.debug("Remove beer");
    }
}
