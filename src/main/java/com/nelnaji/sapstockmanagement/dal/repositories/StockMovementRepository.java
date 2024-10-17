package com.nelnaji.sapstockmanagement.dal.repositories;

import com.nelnaji.sapstockmanagement.dl.entities.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository // this is Optional
public interface StockMovementRepository extends JpaRepository<StockMovement, UUID> {
}
