package com.nelnaji.sapstockmanagement.dal.repositories;

import com.nelnaji.sapstockmanagement.dl.entities.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
}
