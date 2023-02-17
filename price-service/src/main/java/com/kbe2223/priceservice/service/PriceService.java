package com.kbe2223.priceservice.service;

import com.kbe2223.priceservice.entity.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for managing pricing information.
 */
@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    /**
     * Retrieves the price information for a given product ID.
     *
     * @param productId the ID of the product for which to retrieve price information
     * @return the Price object containing the price information, or null if no matching price is found
     */
    public Price getPriceByProductId(Long productId) {
        return priceRepository.findByProductId(productId);
    }

    /**
     * Adds or updates the price information for a given product.
     *
     * @param price the Price object containing the pricing information to add or update
     */
    public void addOrUpdatePrice(Price price) {
        priceRepository.save(price);
    }
}
