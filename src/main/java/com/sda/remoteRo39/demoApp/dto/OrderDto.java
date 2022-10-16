package com.sda.remoteRo39.demoApp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sda.remoteRo39.demoApp.entities.Order;
import com.sda.remoteRo39.demoApp.entities.Product;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
public class OrderDto {

    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private int orderNumber;

    @NotEmpty
    private  int quantity;

    @NotEmpty
    private String status;

    @NotEmpty
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createdDate;

    private List<ProductDto> productList;
}
