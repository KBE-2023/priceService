package com.kbe2223.priceservice.service;

import com.kbe2223.priceservice.entity.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The PriceService class provides the business logic for interacting with the PriceRepository.
 */
@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    /**
     * Retrieves a price record by ID.
     *
     * @param id The ID of the price record to retrieve.
     * @return The retrieved Price object, or null if no record with the specified ID was found.
     */
    public Price getPriceById(Long id) {
        return priceRepository.findById(id).orElse(null);
    }

    /**
     * Returns a list of all prices in the database.
     *
     * @return a list of all prices in the database
     */
    public List<Price> getAllPrices() {
        return priceRepository.findAll();
    }


    /**
     * Creates a new price record.
     *
     * @param price The Price object representing the new price record.
     * @return The created Price object.
     */
    public Price createPrice(Price price) {
        return priceRepository.save(price);
    }

    /**
     * Updates an existing price record.
     *
     * @param id The ID of the price record to update.
     * @param updatedPrice The updated Price object representing the new price information.
     * @return The updated Price object, or null if no record with the specified ID was found.
     */
    public Price updatePrice(Long id, Price updatedPrice) {
        Price existingPrice = priceRepository.findById(id).orElse(null);
        if (existingPrice != null) {
            existingPrice.setPrice(updatedPrice.getPrice());
            return priceRepository.save(existingPrice);
        }
        return null;
    }

    /**
     * Deletes an existing price record.
     *
     * @param id The ID of the price record to delete.
     */
    public void deletePrice(Long id) {
        priceRepository.deleteById(id);
    }

}
