package com.POSSystemGradle.POSSytemGradle.Product;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel,Long> {

    void findByName(String name);
}
