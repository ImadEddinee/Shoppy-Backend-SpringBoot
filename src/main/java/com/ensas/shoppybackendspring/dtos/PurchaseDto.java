package com.ensas.shoppybackendspring.dtos;

import com.ensas.shoppybackendspring.entities.Address;
import com.ensas.shoppybackendspring.entities.Customer;
import com.ensas.shoppybackendspring.entities.Order;
import com.ensas.shoppybackendspring.entities.OrderItem;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class PurchaseDto {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
