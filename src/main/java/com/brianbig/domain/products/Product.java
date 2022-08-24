package com.brianbig.domain.products;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "product")
@AllArgsConstructor @NoArgsConstructor
@Builder @Getter @Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @SequenceGenerator(name = "product_seq")
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column
    private String imageUrl;
    @Column(columnDefinition = "Decimal(5.2) default '1.00'")
    private double price;
}