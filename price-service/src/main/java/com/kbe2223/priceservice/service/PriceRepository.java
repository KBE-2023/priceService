package com.kbe2223.priceservice.service;

import com.kbe2223.priceservice.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {

}
