package com.nelnaji.sapstockmanagement.dl.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode @ToString
public class Address {

    @Column(nullable = false)
    private String Street;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String state;
    @Column(nullable = true)
    private String municipality;
    @Column(nullable = false)
    private String zip;

}
