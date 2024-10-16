package com.nelnaji.sapstockmanagement.dl.entities;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor // will always be needed for JPA and HIBERNATE
@EqualsAndHashCode(of = {"id"})
@ToString
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @Setter
    private UUID id;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public BaseEntity(UUID id) {
        this.id = id;
    }
}
