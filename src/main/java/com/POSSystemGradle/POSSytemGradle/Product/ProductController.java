package com.POSSystemGradle.POSSytemGradle.Product;


import com.POSSystemGradle.POSSytemGradle.Price.Price;
import com.POSSystemGradle.POSSytemGradle.Price.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductRepository productRepo;
    @Autowired
    PriceRepository priceRepo;

    @PostMapping("/add")
    public ProductModel addProduct(@RequestBody ProductModel product)
    {
        Price priceTable=new Price();
        priceTable=product.getPriceTable();
        ProductModel newProduct=new ProductModel();
        newProduct.setId(product.getId());
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        newProduct.setPriceTable(priceTable);
        return productRepo.save(newProduct);
    }
    @GetMapping("/{id}")
    public ProductModel getproduct(@PathVariable int id)
    {
        return productRepo.findById((long) id).orElse(null);
    }
}
