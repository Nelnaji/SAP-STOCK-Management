package com.nelnaji.sapstockmanagement.dal.repositories;

import com.nelnaji.sapstockmanagement.dl.entities.person.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}
