package com.programmingtechie.orderservice.controller;

import com.programmingtechie.orderservice.dto.OrderLineItemsDto;
import com.programmingtechie.orderservice.dto.OrderRequest;
import com.programmingtechie.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        List<OrderLineItemsDto> ol = orderRequest.getOrderLineItemsDtoList();

        for (OrderLineItemsDto ols :
             ol) {
            System.out.println("--------->"+ols.toString());
        }

        orderService.placeOrder(orderRequest);
        return "Order Placed Successfully";
    }
}
