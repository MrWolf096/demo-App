package com.sda.remoteRo39.demoApp.repository;

import com.sda.remoteRo39.demoApp.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    List<Product> findAllByName(String name);

    List<Product> findAllByNameAndPrice(String name, double price);

    List<Product> findAllByPrice(double price);

    List<Product> findAllByCategory(String category);

    List<Product> findAllByCategoryAndPrice(String category, double price);







}
