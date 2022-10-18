package com.POSSystemGradle.POSSytemGradle;

import com.POSSystemGradle.POSSytemGradle.Product.ProductController;
import com.POSSystemGradle.POSSytemGradle.Price.Price;
import com.POSSystemGradle.POSSytemGradle.Product.ProductModel;
import com.POSSystemGradle.POSSytemGradle.Product.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;
import java.util.Optional;

import static com.POSSystemGradle.POSSytemGradle.Price.Currency.INR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {
    @Autowired
    private ProductController productController;
    @MockBean
    private ProductRepository productRepository;
    @Test
    public void addProduct()
    {
        ProductModel product=new ProductModel(1,50,"apple", new Price());
        when(productController.addProduct(product)).thenReturn(product);
        assertEquals(product,productController.addProduct(product));
    }
    @Test
    public void getProductDescriptionById()
    {
        ProductModel product=new ProductModel(1,50,"apple",new Price());

        when(productRepository.findById((long) product.getId())).thenReturn(Optional.of(product));
        assertEquals(product,productController.getproduct((int) product.getId()));
    }

    @Test
    public void productIsNUllWhenIdIsNotPresent()
    {
        ProductModel product=new ProductModel(1,50,"apple",new Price());

        when(productRepository.findById((long) product.getId())).thenReturn(Optional.of(product));
        assertNull(productController.getproduct(2));
    }
}
