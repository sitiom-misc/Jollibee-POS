package com.example.entjavamp1.controller;

import com.example.entjavamp1.model.tables.records.OrdersRecord;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;
import org.jooq.Result;

import static com.example.entjavamp1.model.Tables.*;

import java.io.IOException;

@WebServlet("/served")
public class ServedOrdersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DSLContext create = (DSLContext) getServletContext().getAttribute("dslContext");
        Result<OrdersRecord> orders = create.selectFrom(ORDERS).where(ORDERS.ISPENDING.eq(false)).fetch();
        req.setAttribute("orders", orders);
        getServletContext().getRequestDispatcher("/WEB-INF/served.jsp").forward(req, resp);
    }
}
