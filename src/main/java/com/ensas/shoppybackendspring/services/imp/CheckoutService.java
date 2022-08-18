package com.ensas.shoppybackendspring.services.imp;

import com.ensas.shoppybackendspring.dtos.PurchaseDto;
import com.ensas.shoppybackendspring.dtos.PurchaseResponseDto;
import com.ensas.shoppybackendspring.entities.Customer;
import com.ensas.shoppybackendspring.entities.Order;
import com.ensas.shoppybackendspring.entities.OrderItem;
import com.ensas.shoppybackendspring.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckoutService {

    private final CustomerRepository customerRepository;

    public PurchaseResponseDto placeOrder(PurchaseDto purchaseDto){
        Order order = purchaseDto.getOrder();
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);
        Set<OrderItem> orderItems = purchaseDto.getOrderItems();
        orderItems.forEach(orderItem -> order.add(orderItem));
        order.setBillingAddress(purchaseDto.getBillingAddress());
        order.setShippingAddress(purchaseDto.getShippingAddress());
        Customer customer = purchaseDto.getCustomer();
        customer.add(order);
        customerRepository.save(customer);
        return new PurchaseResponseDto(orderTrackingNumber);
    }

    public String generateOrderTrackingNumber(){
        return UUID.randomUUID().toString();
    }
}
