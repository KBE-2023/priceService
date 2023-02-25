package com.kbe2223.priceservice.controller;

import com.kbe2223.priceservice.entity.Price;
import com.kbe2223.priceservice.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The PriceController class defines the REST endpoints for the Price service.
 */
@RestController
@RequestMapping("/price")
public class PriceController {

    @Autowired
    private PriceService priceService;

    /**
     * Retrieves a price record by ID.
     *
     * @param id The ID of the price record to retrieve.
     * @return A ResponseEntity containing the retrieved Price and an HTTP status code.
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<Price> getPriceById(@PathVariable Long id) {
        Price price = priceService.getPriceById(id);
        if (price != null) {
            return new ResponseEntity<>(price, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    /**
     * Returns a list of all prices in the database.
     *
     * @return a list of all prices in the database, or NOT_FOUND if the database is empty
     */
    @GetMapping("/get/all")
    public ResponseEntity<List<Price>> getAllPrices() {
        List<Price> prices = priceService.getAllPrices();
        if (!prices.isEmpty()) {
            return new ResponseEntity<>(prices, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    /**
     * Creates a new price record.
     *
     * @param price The Price object representing the new price record.
     * @return A ResponseEntity containing the created Price and an HTTP status code.
     */
    @PostMapping
    public ResponseEntity<Price> createPrice(@RequestBody Price price) {
        Price createdPrice = priceService.createPrice(price);
        return new ResponseEntity<>(createdPrice, HttpStatus.CREATED);
    }

    /**
     * Updates an existing price record.
     *
     * @param id The ID of the price record to update.
     * @param price The updated Price object representing the new price information.
     * @return A ResponseEntity containing the updated Price and an HTTP status code.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Price> updatePrice(@PathVariable Long id, @RequestBody Price price) {
        Price updatedPrice = priceService.updatePrice(id, price);
        if (updatedPrice != null) {
            return new ResponseEntity<>(updatedPrice, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Deletes an existing price record.
     *
     * @param id The ID of the price record to delete.
     * @return A ResponseEntity with an HTTP status code indicating success or failure.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePrice(@PathVariable Long id) {
        priceService.deletePrice(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
