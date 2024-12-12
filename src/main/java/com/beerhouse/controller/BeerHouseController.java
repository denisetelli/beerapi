package com.beerhouse.controller;

import com.beerhouse.api.request.BeerRequest;
import com.beerhouse.api.response.BeerResponse;
import com.beerhouse.service.BeerCatalogService;
import io.swagger.annotations.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api/beer-catalog")
public class BeerHouseController {

    @Autowired
    BeerCatalogService beerCatalogService;

    @PostMapping("/addBeer")
    public BeerResponse addBeer(BeerRequest beerRequest) {
        return beerCatalogService.addBeer(beerRequest);
    }

    @DeleteMapping("/deleteBeer/{id}")
    public void deleteBeer(int beerId) {
        beerCatalogService.deleteBeer(beerId);
    }

    @PutMapping("/updateBeer/{id}")
    public BeerResponse updateBeer(@PathVariable Integer id, BeerRequest beerRequest) {
        return beerCatalogService.updateBeer(id, beerRequest);
    }

    @ApiResponse(code = 200, response = BeerResponse.class, message = "Success")
    @Operation(description = "Get a beer by ID.")
    @GetMapping("/getBeer/{id}")
    public BeerResponse getBeerById(@Parameter(description = "Beer ID", required = true)
                                    @PathVariable int beerId) {
        return beerCatalogService.getById(beerId);
    }

    @GetMapping("/beers")
    public List<BeerResponse> getBeers(@PathVariable int beerId) {
        return beerCatalogService.getAll();
    }

}
