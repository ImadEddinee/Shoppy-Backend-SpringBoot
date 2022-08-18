package com.ensas.shoppybackendspring.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.support.ManagedArray;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor
@Table(name = "CUSTOMER")
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
    public void add(Order order){
        if (order != null){
            if (orders == null){
                orders = new ArrayList<>();
            }
            orders.add(order);
            order.setCustomer(this);
        }
    }
}
