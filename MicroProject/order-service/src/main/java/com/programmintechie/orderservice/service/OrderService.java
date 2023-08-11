package com.programmintechie.orderservice.service;

import com.programmintechie.orderservice.dto.OrderLineItemsdto;
import com.programmintechie.orderservice.dto.OrderRequest;
import com.programmintechie.orderservice.model.Order;
import com.programmintechie.orderservice.model.OrderLineItems;
import com.programmintechie.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNimber(UUID.randomUUID().toString());
        orderRequest.getOrderLineItemsdtoList()
                .stream()
                .map(this:: mapToDto)
                .toList();
        orderRepository.save(order);
    }

    private OrderLineItems mapToDto(OrderLineItemsdto orderLineItemsdto){
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsdto.getPrice());
        orderLineItems.setQuantity(orderLineItemsdto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsdto.getSkuCode());
        return orderLineItems;
    }

}
