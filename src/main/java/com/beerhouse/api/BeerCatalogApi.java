package com.beerhouse.api;

import com.beerhouse.api.request.BeerRequest;
import com.beerhouse.api.response.BeerResponse;
import com.beerhouse.exception.BeerHouseException;
import com.beerhouse.service.BeerCatalogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/beer-catalog")
@Validated
public class BeerCatalogApi {

    @Autowired
    private BeerCatalogService catalogService;

    @PostMapping
    @ApiOperation(value = "Add a beer to the catalog.", response = BeerResponse.class)
    public ResponseEntity<BeerResponse> addBeer(@RequestBody @Valid BeerRequest beer) {
        try {
            return ResponseEntity.ok(catalogService.addBeer(beer));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping
    @ApiOperation(value = "Delete a beer from the catalog.")
    public ResponseEntity<Void> deleteBeer(@RequestParam Integer id) {
        try {
            catalogService.deleteBeer(id);
            return ResponseEntity.ok().build();
        } catch (BeerHouseException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    @ApiOperation(value = "Update a beer from the catalog.", response = BeerResponse.class)
    public ResponseEntity<BeerResponse> updateBeer(@RequestParam Integer id, @RequestBody @Valid BeerRequest beer) {
        try {
            return ResponseEntity.ok(catalogService.updateBeer(id, beer));
        } catch (BeerHouseException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/beers")
    @ApiOperation(value = "Get the beer catalog.", response = BeerResponse[].class)
    public ResponseEntity<List<BeerResponse>> getCatalog() {

        return ResponseEntity.ok(catalogService.getAll());
    }

    @GetMapping("/beer")
    @ApiOperation(value = "Get a beer by id.", response = BeerResponse.class)
    public ResponseEntity<BeerResponse> getBeer(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(catalogService.getById(id));
        } catch (BeerHouseException ex) {
            return ResponseEntity.notFound().build();
        }
    }

}