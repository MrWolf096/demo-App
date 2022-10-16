package com.sda.remoteRo39.demoApp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "orderNumber", nullable = false)
    private int orderNumber;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "createdDate", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createdDate;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Product> products;
}
