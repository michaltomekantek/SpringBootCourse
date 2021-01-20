package com.course.rest.web.mappers;

import com.course.rest.domain.Beer;
import com.course.rest.web.model.BeerDTO;
import com.course.rest.web.model.BeerStyleEnum;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-14T17:07:42+0000",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_261 (Oracle Corporation)"
)
@Component
public class BeerMapperImpl implements BeerMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public BeerDTO beerToBeerDTO(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerDTO beerDTO = new BeerDTO();

        beerDTO.setId( beer.getId() );
        if ( beer.getVersion() != null ) {
            beerDTO.setVersion( beer.getVersion().intValue() );
        }
        beerDTO.setLastModifiedDate( dateMapper.asOffsetDateTime( beer.getLastModifiedDate() ) );
        beerDTO.setBeerName( beer.getBeerName() );
        if ( beer.getBeerStyle() != null ) {
            beerDTO.setBeerStyle( Enum.valueOf( BeerStyleEnum.class, beer.getBeerStyle() ) );
        }
        beerDTO.setUpc( beer.getUpc() );
        beerDTO.setPrice( beer.getPrice() );

        return beerDTO;
    }

    @Override
    public Beer beerDTOToBeer(BeerDTO beerDTO) {
        if ( beerDTO == null ) {
            return null;
        }

        Beer beer = new Beer();

        beer.setId( beerDTO.getId() );
        if ( beerDTO.getVersion() != null ) {
            beer.setVersion( beerDTO.getVersion().longValue() );
        }
        beer.setLastModifiedDate( dateMapper.asTimestamp( beerDTO.getLastModifiedDate() ) );
        beer.setBeerName( beerDTO.getBeerName() );
        if ( beerDTO.getBeerStyle() != null ) {
            beer.setBeerStyle( beerDTO.getBeerStyle().name() );
        }
        beer.setUpc( beerDTO.getUpc() );
        beer.setPrice( beerDTO.getPrice() );

        return beer;
    }
}
