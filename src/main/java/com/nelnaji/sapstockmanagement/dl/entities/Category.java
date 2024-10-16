package com.nelnaji.sapstockmanagement.dl.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Category extends BaseEntity {

    @Column(nullable = false, length = 80)
    private String designation;

    public Category(UUID id, String designation) {
        super(id);
        this.designation = designation;
    }
}
