package com.kbe2223.priceservice.controller;

import com.kbe2223.priceservice.entity.Price;
import com.kbe2223.priceservice.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing pricing information.
 */
@RestController
@RequestMapping("/prices")
public class PriceController {

    @Autowired
    private PriceService priceService;

    /**
     * Retrieves the pricing information for a given product ID.
     *
     * @param productId the ID of the product for which to retrieve pricing information
     * @return the pricing information as a JSON object, or a 404 error if no matching price is found
     */
    @GetMapping("/{productId}")
    public ResponseEntity<Price> getPriceByProductId(@PathVariable Long productId) {
        Price price = priceService.getPriceByProductId(productId);
        if (price != null) {
            return new ResponseEntity<>(price, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Adds or updates the pricing information for a given product.
     *
     * @param price the pricing information as a JSON object
     * @return a 201 CREATED status code if the pricing information was added or updated successfully
     */
    @PostMapping
    public ResponseEntity<Void> addOrUpdatePrice(@RequestBody Price price) {
        priceService.addOrUpdatePrice(price);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
