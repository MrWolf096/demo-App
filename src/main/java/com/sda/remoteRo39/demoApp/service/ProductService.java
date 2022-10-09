package com.sda.remoteRo39.demoApp.service;

import com.sda.remoteRo39.demoApp.entities.Product;
import com.sda.remoteRo39.demoApp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    //Find all the products - Get
    public List<Product> findAll(){
        return productRepo.findAll();
    }

    //Find all  the products by the id - Get
    public Optional<Product> findById(Long id){
        return productRepo.findById(id);
    }

    //Find all the products by name - Get
    public List<Product> findAllByName(String name){
        return productRepo.findAllByName(name);
    }


    public List<Product> findAllByPrice(double price){
        return productRepo.findAllByPrice(price);
    }

    //Create a product - POST
    public Product addProduct(Product product){
        return productRepo.save(product);
    }

    //Edit/Update a product - Put
    public Product editProduct(Product product){
        return productRepo.save(product);
    }

    //DELETE a product - DELETE
    public void deleteProductByID(Long id){
        productRepo.deleteById(id);
    }
}
