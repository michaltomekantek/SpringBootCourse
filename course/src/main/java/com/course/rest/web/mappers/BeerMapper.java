package com.course.rest.web.mappers;

import com.course.rest.domain.Beer;
import com.course.rest.web.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDTO beerToBeerDTO(Beer beer);
    Beer beerDTOToBeer(BeerDTO beerDTO);
}
