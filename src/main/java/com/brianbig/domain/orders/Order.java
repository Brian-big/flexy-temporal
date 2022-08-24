package com.brianbig.domain.orders;

import com.brianbig.domain.customer.Customer;
import com.brianbig.domain.products.Product;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @SequenceGenerator(name = "order_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    private Customer customer;

    @OneToMany
    private List<Product> products;

    @Column
    private String shipmentStatus;

    @Transient
    private double total;

    public double getTotal() {
        double total_ = 0.0;
        for (Product p :
                products) {
            total += p.getPrice();
        }
        return total_;
    }
}