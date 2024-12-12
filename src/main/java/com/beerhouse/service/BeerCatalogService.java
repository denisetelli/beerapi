package com.beerhouse.service;

import com.beerhouse.api.request.BeerRequest;
import com.beerhouse.api.response.BeerResponse;
import com.beerhouse.exception.BeerHouseException;
import com.beerhouse.mapper.BeerMapper;
import com.beerhouse.model.Beer;
import com.beerhouse.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeerCatalogService {

    public static final String BEER_NOT_FOUND = "Beer not found.";

    @Autowired
    BeerRepository beerRepository;

    @Transactional
    public BeerResponse addBeer(BeerRequest beerRequest) {
        Beer beer = beerRepository.save(BeerMapper.mapRequest(beerRequest));
        return BeerMapper.mapResponse(beer);
    }

    @Transactional
    public void deleteBeer(Integer id) {
        Beer repositoryBeer = beerRepository.findById(id)
                .orElseThrow(() -> new BeerHouseException(BEER_NOT_FOUND));

        beerRepository.delete(repositoryBeer);
    }

    @Transactional
    public BeerResponse updateBeer(Integer id, BeerRequest beer) {
        Beer repositoryBeer = beerRepository.findById(id)
                .orElseThrow(() -> new BeerHouseException(BEER_NOT_FOUND));

        repositoryBeer.setName(beer.getName());
        repositoryBeer.setStyle(beer.getStyle());
        repositoryBeer.setBrewery(beer.getBrewery());
        repositoryBeer.setAlcVol(beer.getAlcVol());
        repositoryBeer.setMl(beer.getMl());
        beerRepository.save(repositoryBeer);
        return BeerMapper.mapResponse(repositoryBeer);
    }

    public List<BeerResponse> getAll() {
        return beerRepository.findAll()
                .stream()
                .map(BeerMapper::mapResponse)
                .collect(Collectors.toList());
    }

    public BeerResponse getById(Integer beerId) {
        return beerRepository
                .findById(beerId)
                .map(BeerMapper::mapResponse)
                .orElseThrow(() -> new BeerHouseException(BEER_NOT_FOUND));
    }

}