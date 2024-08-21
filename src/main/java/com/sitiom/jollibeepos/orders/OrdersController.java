package com.sitiom.jollibeepos.orders;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class OrdersController {
    private final OrdersService ordersService;
    private final Map<String, Double> menu;

    public OrdersController(OrdersService ordersService, Map<String, Double> menu) {
        this.ordersService = ordersService;
        this.menu = menu;
    }

    @GetMapping("/order")
    public String order(Model model) {
        model.addAttribute("order", new Order());
        return "order";
    }

    @PostMapping("/order")
    public String order(Order order, Model model) {
        double price = menu.get(order.getItem()) * order.getQuantity(); // should be @Transient or something
        order.setPrice(price);
        ordersService.saveOrder(order);
        model.addAttribute("title", "Order received!");
        model.addAttribute("order", order);
        return "entry";
    }

    @GetMapping("/served")
    public String served(Model model) {
        model.addAttribute("orders", ordersService.getServedOrders());
        return "served";
    }

    @GetMapping("/pending")
    public String pending(Model model) {
        model.addAttribute("orders", ordersService.getPendingOrders());
        return "pending";
    }

    @GetMapping("/serve/{id}")
    public String serve(@PathVariable int id, Model model) {
        ordersService.getOrder(id).ifPresent(order -> {
            order.setPending(false);
            ordersService.saveOrder(order);
        });
        return "redirect:/pending";
    }

    @GetMapping("/print/{id}")
    public String print(Model model, @PathVariable int id) {
        model.addAttribute("title", "Thank you for dining with us! Here is your receipt:");
        ordersService.getOrder(id).ifPresent(order -> model.addAttribute("order", order));
        return "entry";
    }
}
