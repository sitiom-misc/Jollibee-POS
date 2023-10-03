package com.example.entjavamp1.controller;

import com.example.entjavamp1.model.tables.records.OrdersRecord;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;
import org.jooq.types.ULong;

import java.io.IOException;

import static com.example.entjavamp1.model.Tables.ORDERS;

@WebServlet("/serve/*")
public class ServeOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ULong id = ULong.valueOf(req.getPathInfo().split("/")[1]);
        DSLContext create = (DSLContext) getServletContext().getAttribute("dslContext");
        OrdersRecord order = create.selectFrom(ORDERS).where(ORDERS.ID.eq(id)).fetchOne();
        if (order != null) {
            order.setIspending(false);
            order.store();
        }

        resp.sendRedirect(req.getContextPath() + "/pending");
    }
}