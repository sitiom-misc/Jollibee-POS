package com.example.entjavame2.controller;

import com.example.entjavame2.model.tables.records.StudentRecord;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;
import org.jooq.Result;

import java.io.IOException;

import static com.example.entjavame2.model.Tables.*;

@WebServlet("/students/deleted")
public class DeletedStudentsServlet extends HttpServlet {
    private DSLContext dsl;

    @Override
    public void init() throws ServletException {
        super.init();
        dsl = (DSLContext) getServletContext().getAttribute("dslContext");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Result<StudentRecord> students = dsl.selectFrom(STUDENT).where(STUDENT.ISDELETED.eq(true)).fetch();
        req.setAttribute("students", students);
        getServletContext().getRequestDispatcher("/WEB-INF/deleted.jsp").forward(req, resp);
    }
}
