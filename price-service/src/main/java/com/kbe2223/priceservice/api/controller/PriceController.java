package com.kbe2223.priceservice.api.controller;

import com.kbe2223.priceservice.api.entity.Price;
import com.kbe2223.priceservice.api.service.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/price")
public class PriceController {

    @Autowired
    private PriceRepository priceRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Price> getPriceById(@PathVariable Long id) {
        Price price = priceRepository.findById(id).orElse(null);
        if (price == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(price, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Price> updatePrice(@PathVariable Long id, @RequestBody Price newPrice) {
        Price price = priceRepository.findById(id).orElse(null);
        if (price == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        price.setPrice(newPrice.getPrice());
        price.setCurrency(newPrice.getCurrency());
        Price updatedPrice = priceRepository.save(price);
        return new ResponseEntity<>(updatedPrice, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePrice(@PathVariable Long id) {
        Price price = priceRepository.findById(id).orElse(null);
        if (price == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        priceRepository.delete(price);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
