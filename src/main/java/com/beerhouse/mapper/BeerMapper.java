package com.beerhouse.mapper;

import com.beerhouse.api.request.BeerRequest;
import com.beerhouse.api.response.BeerResponse;
import com.beerhouse.model.Beer;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BeerMapper {

    public static Beer mapRequest(BeerRequest beerRequest) {
        return Beer.builder()
                .alcVol(beerRequest.getAlcVol())
                .ml(beerRequest.getMl())
                .brewery(beerRequest.getBrewery())
                .name(beerRequest.getName())
                .style(beerRequest.getStyle())
                .price(beerRequest.getPrice())
                .build();
    }

    public static BeerResponse mapResponse(Beer beer) {
        return BeerResponse.builder()
                .id(beer.getId())
                .alcVol(beer.getAlcVol())
                .ml(beer.getMl())
                .brewery(beer.getBrewery())
                .name(beer.getName())
                .style(beer.getStyle())
                .price(beer.getPrice())
                .build();
    }
}