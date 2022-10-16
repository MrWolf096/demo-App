package com.sda.remoteRo39.demoApp.dto;

import com.sda.remoteRo39.demoApp.entities.Order;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Data
public class ProductDto {

    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @NotEmpty
    private double price;

    @NotEmpty
    private String category;

    @NotEmpty
    private String imagePath;
}
