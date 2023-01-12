package com.kbe2223.priceservice.api.controller;

import com.kbe2223.priceservice.api.model.PriceItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/price")
public class PriceController {

   @RequestMapping("/{userId}")
    public Set<PriceItem> getPrice(@PathVariable("userId") String userId){
        return Collections.singleton(
          new PriceItem("Summer T-shirt", "For boys", 19.99
        ));

    }
}
