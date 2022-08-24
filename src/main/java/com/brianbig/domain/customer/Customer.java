package com.brianbig.domain.customer;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @Builder
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq")
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private String email;
    @Column
    private String telephone;
    @Column
    private String address;


}