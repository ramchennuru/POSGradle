package com.POSSystemGradle.POSSytemGradle.Price;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/price")
public class PriceController {

    @Autowired
    PriceRepository priceRepository;
    @PostMapping("/add")
    public Price addPrice(@RequestBody Price price)
    {
        Price existPrice=priceRepository.findById(price.getId()).orElse(null);
        existPrice.setPrice(price.getPrice());
        existPrice.setEndDate(price.getEndDate());
        existPrice.setEndDate(price.getEndDate());
        existPrice.setVatCode(price.getVatCode());
        existPrice.setCurrency(price.getCurrency());
        return priceRepository.save(existPrice);
    }
    @GetMapping("/{id}")
    public Price getPrice(@PathVariable int id)
    {
       return priceRepository.findById(id).orElse(null);
    }
}
