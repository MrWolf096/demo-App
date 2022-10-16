package com.sda.remoteRo39.demoApp.repository;

import com.sda.remoteRo39.demoApp.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {


}
