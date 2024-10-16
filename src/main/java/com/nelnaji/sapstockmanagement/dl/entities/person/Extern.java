package com.nelnaji.sapstockmanagement.dl.entities.person;

import com.nelnaji.sapstockmanagement.dl.entities.Address;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn( name="extern_type" ) // name used in SQL
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
public abstract class Extern extends Person{

    @Column(length =  17)
    private String phoneNumber;

    @Embedded
    private Address address;

    public Extern(UUID id, String firstName, String lastName, String email, String phoneNumber, Address address) {
        super(id, firstName, lastName, email);
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
