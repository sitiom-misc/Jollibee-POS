package com.sitiom.jollibeepos;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Map;

@ControllerAdvice
public class GlobalData {
    @ModelAttribute("requestUri")
    public String requestUri(HttpServletRequest request) {
        return request.getRequestURI();
    }

    @ModelAttribute("menu")
    @Bean
    public Map<String, Double> menu() {
        return Map.of(
                "Chickenjoy", 82.0,
                "Jolly Spaghetti", 60.0,
                "Burger Steak", 63.0,
                "Yumburger", 40.0,
                "Chicken Sandwich", 149.0,
                "Palabok", 138.0
        );
    }
}
