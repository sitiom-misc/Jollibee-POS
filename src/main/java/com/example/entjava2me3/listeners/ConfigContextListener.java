package com.example.entjava2me3.listeners;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.util.HashMap;
import java.util.Map;

@WebListener
public class ConfigContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Map<String, Double> menu = new HashMap<>();
        menu.put("Chickenjoy", 82.0);
        menu.put("Jolly Spaghetti", 60.0);
        menu.put("Burger Steak", 63.0);
        menu.put("Yumburger", 40.0);
        menu.put("Chicken Sandwhich", 149.0);
        menu.put("Palabok", 138.0);

        sce.getServletContext().setAttribute("menu", menu);
    }
}