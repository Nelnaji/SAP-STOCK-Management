package com.nelnaji.sapstockmanagement.dl.entities.person;

import com.nelnaji.sapstockmanagement.dl.entities.Address;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.UUID;

@Entity
@DiscriminatorValue("client")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
public class Client extends Extern {

    public Client(UUID id, String firstName, String lastName, String email, String phoneNumber, Address address) {
        super(id, firstName, lastName, email, phoneNumber, address);
    }

}
