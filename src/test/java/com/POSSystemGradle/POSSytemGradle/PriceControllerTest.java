package com.POSSystemGradle.POSSytemGradle;

import com.POSSystemGradle.POSSytemGradle.Price.Currency;
import com.POSSystemGradle.POSSytemGradle.Price.Price;
import com.POSSystemGradle.POSSytemGradle.Price.PriceController;
import com.POSSystemGradle.POSSytemGradle.Price.PriceRepository;
import com.POSSystemGradle.POSSytemGradle.Product.ProductController;
import com.POSSystemGradle.POSSytemGradle.Product.ProductModel;
import com.POSSystemGradle.POSSytemGradle.Product.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PriceControllerTest {
    @Autowired
    private PriceController priceController;
    @MockBean
    private PriceRepository priceRepository;
    @Test
    public void addProduct()
    {
        Price price=new Price(1,20,new Date(2022-02-25),new Date(2022-12-25),876545, Currency.INR);

        when(priceController.addPrice(price)).thenReturn(price);

        assertEquals(price,priceController.addPrice(price));
    }
    @Test
    public void getProductDescriptionById()
    {
        Price price=new Price(1,20,new Date(2022-02-25),new Date(2022-12-25),876545, Currency.INR);

        when(priceRepository.findById(price.getId())).thenReturn(Optional.of(price));
        assertEquals(price,priceController.getPrice(price.getId()));
    }

    @Test
    public void productIsNUllWhenIdIsNotPresent()
    {
        Price price=new Price(1,20,new Date(2022-02-25),new Date(2022-12-25),876545, Currency.INR);

        when(priceRepository.findById(price.getId())).thenReturn(Optional.of(price));
        assertNull(priceController.getPrice(2));
    }
}
