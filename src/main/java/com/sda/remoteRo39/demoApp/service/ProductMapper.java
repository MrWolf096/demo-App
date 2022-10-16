package com.sda.remoteRo39.demoApp.service;

import com.sda.remoteRo39.demoApp.dto.OrderDto;
import com.sda.remoteRo39.demoApp.dto.ProductDto;
import com.sda.remoteRo39.demoApp.entities.Order;
import com.sda.remoteRo39.demoApp.entities.Product;
import com.sda.remoteRo39.demoApp.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductMapper implements Mapper<Product, ProductDto>{

    public List<ProductDto> listConvertToDto(List<Product> entity){
        List<ProductDto> result = new ArrayList<>();
        for (Product product : entity) {
            ProductDto productDto = convertToDto(product);
            result.add(productDto);
        }
        return result;
    }

    public List<Product> listConvertToEntity(List<ProductDto> productDto){
        List<Product> result = new ArrayList<>();
        for (ProductDto productDto1 : productDto) {
            Product product1 = convertToEntity(productDto1);
            result.add(product1);
        }
        return result;
    }

    @Override
    public Product convertToEntity(ProductDto entity) {
        Product product = new Product();
        product.setName(entity.getName());
        product.setDescription(entity.getDescription());
        product.setPrice(entity.getPrice());
        product.setCategory(entity.getCategory());
        product.setImagePath(entity.getImagePath());

        return product;
    }

    @Override
    public ProductDto convertToDto(Product dto) {
        ProductDto productDto = new ProductDto();
        productDto.setName(dto.getName());
        productDto.setDescription(dto.getDescription());
        productDto.setPrice(dto.getPrice());
        productDto.setCategory(dto.getCategory());
        productDto.setImagePath(dto.getImagePath());
        return productDto;
    }


}
