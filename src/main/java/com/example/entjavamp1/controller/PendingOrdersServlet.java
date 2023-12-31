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

@WebServlet("/pending")
public class PendingOrdersServlet extends HttpServlet {
    private DSLContext dsl;

    @Override
    public void init() throws ServletException {
        super.init();
        dsl = (DSLContext) getServletContext().getAttribute("dslContext");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Result<OrdersRecord> orders = dsl.selectFrom(ORDERS).where(ORDERS.ISPENDING.eq(true)).fetch();
        req.setAttribute("orders", orders);
        getServletContext().getRequestDispatcher("/WEB-INF/pending.jsp").forward(req, resp);
    }
}
