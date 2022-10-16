package com.sda.remoteRo39.demoApp.controllers;

import com.sda.remoteRo39.demoApp.dto.OrderDto;
import com.sda.remoteRo39.demoApp.exeption.ResourceNotFoundException;
import com.sda.remoteRo39.demoApp.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/orders")
public class OrderControllerANG {

    @Autowired
    private OrderService orderService;

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public String handleException(ResourceNotFoundException exception){
        log.error(exception.getMessage());
        return "Resource not found.";
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> findAllOrders(){
        List<OrderDto> allOrders = orderService.findAllOrders();

        return new ResponseEntity<>(allOrders, HttpStatus.OK);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderDto> findById(@PathVariable Long id){
        OrderDto orderDto = orderService.findById(id).get();
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

    @PostMapping("/createOrder")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto){
        OrderDto dto = orderService.createOrder(orderDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("/editOrder/{id}")
    public ResponseEntity<OrderDto> editOrder(@RequestBody OrderDto orderDto , @PathVariable Long id){
        OrderDto dto = orderService.editOrder(id,orderDto);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/deleteOrder/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
        return new ResponseEntity<>("The order with id " + id + " has been deleted successfully.", HttpStatus.OK);
    }


}
