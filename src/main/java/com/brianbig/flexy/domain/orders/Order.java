package com.brianbig.flexy.domain.orders;

import com.brianbig.flexy.domain.customer.Customer;
import com.brianbig.flexy.domain.products.Product;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "\"order\"")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @SequenceGenerator(name = "order_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    private Customer customer;

    @OneToOne
    private Product product;

    @Column
    private String shipmentStatus;

}