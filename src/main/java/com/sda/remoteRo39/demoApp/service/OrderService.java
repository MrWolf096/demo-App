package com.sda.remoteRo39.demoApp.service;

import com.sda.remoteRo39.demoApp.dto.OrderDto;
import com.sda.remoteRo39.demoApp.entities.Order;
import com.sda.remoteRo39.demoApp.exeption.ResourceNotFoundException;
import com.sda.remoteRo39.demoApp.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderMapper orderMapper;

    public List<OrderDto> findAllOrders(){
        return orderRepo.findAll().stream().map(order -> orderMapper.convertToDto(order)).collect(Collectors.toList());
    }

    public Optional<OrderDto> findById(Long id){
        Order order = orderRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Order with the id " + id + " not found"));
        return Optional.ofNullable(orderMapper.convertToDto(order));
    }

    public OrderDto createOrder(OrderDto orderDto){
        Order order = orderMapper.convertToEntity(orderDto);
        orderRepo.save(order);
        return orderMapper.convertToDto(order);
    }

    public OrderDto editOrder(Long id, OrderDto dto){
        Order order = orderRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Order with the id " + id + " not found"));
        order.setName(dto.getName());
        order.setOrderNumber(dto.getOrderNumber());
        order.setQuantity(dto.getQuantity());
        order.setStatus(dto.getStatus());
        order.setCreatedDate(dto.getCreatedDate());
       // order.setProducts(dto.getProducts());

        return orderMapper.convertToDto(order);
    }

    public void deleteOrder(Long id){
        Order order = orderRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Order with the id " + id + " not found"));
        orderRepo.delete(order);
    }
}
