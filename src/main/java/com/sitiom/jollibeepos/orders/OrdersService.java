package com.sitiom.jollibeepos.orders;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public List<Order> getPendingOrders() {
        return ordersRepository.findAllByPending(true);
    }

    public List<Order> getServedOrders() {
        return ordersRepository.findAllByPending(false);
    }

    public Optional<Order> getOrder(int id) {
        return ordersRepository.findById(id);
    }

    public void saveOrder(Order order) {
        ordersRepository.save(order);
    }
}
