package com.example.entjavamp1.controller;


import com.example.entjavamp1.model.enums.OrdersOrder;
import com.example.entjavamp1.model.tables.records.OrdersRecord;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;
import org.jooq.types.UInteger;

import java.io.IOException;
import java.util.HashMap;

import static com.example.entjavamp1.model.Tables.*;

@WebServlet("/success")
public class OrderSuccessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Double> menu = (HashMap<String, Double>) getServletContext().getAttribute("menu");
        String item = req.getParameter("item");
        UInteger quantity = UInteger.valueOf(req.getParameter("qty"));
        Double price = menu.get(item) * quantity.doubleValue();

        DSLContext create = (DSLContext) getServletContext().getAttribute("dslContext");
        OrdersRecord newOrder = create.newRecord(ORDERS);
        newOrder.setName(req.getParameter("name"));
        newOrder.setOrder(OrdersOrder.lookupLiteral(item));
        newOrder.setQuantity(quantity);
        newOrder.setIspending(true);
        newOrder.setPrice(price);
        newOrder.store();

        req.setAttribute("message", "Order has been placed!");
        req.setAttribute("order", newOrder);

        getServletContext().getRequestDispatcher("/WEB-INF/success.jsp").forward(req, resp);
    }
}
