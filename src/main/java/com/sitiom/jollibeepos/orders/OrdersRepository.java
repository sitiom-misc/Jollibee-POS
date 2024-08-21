package com.sitiom.jollibeepos.orders;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByPending(boolean pending);
}
