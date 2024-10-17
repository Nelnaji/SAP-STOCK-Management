package com.nelnaji.sapstockmanagement.dal.repositories;

import com.nelnaji.sapstockmanagement.dl.entities.order.ClientOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientOrderRepository extends JpaRepository<ClientOrder, UUID> {
}
