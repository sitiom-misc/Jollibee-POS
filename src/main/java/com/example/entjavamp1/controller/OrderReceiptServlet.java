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

@WebServlet("/print/*")
public class OrderReceiptServlet extends HttpServlet {
    private DSLContext dsl;

    @Override
    public void init() throws ServletException {
        super.init();
        dsl = (DSLContext) getServletContext().getAttribute("dslContext");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ULong id = ULong.valueOf(req.getPathInfo().split("/")[1]);
        OrdersRecord order = dsl.selectFrom(ORDERS).where(ORDERS.ID.eq(id)).fetchOne();
        req.setAttribute("message", "Thank you for dining with us! Here is your receipt:");
        req.setAttribute("order", order);

        getServletContext().getRequestDispatcher("/WEB-INF/success.jsp").forward(req, resp);
    }
}
