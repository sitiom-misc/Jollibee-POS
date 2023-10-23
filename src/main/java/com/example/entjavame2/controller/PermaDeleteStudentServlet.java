package com.example.entjavame2.controller;

import com.example.entjavame2.model.tables.records.StudentRecord;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;
import org.jooq.types.ULong;

import java.io.IOException;

import static com.example.entjavame2.model.Tables.*;

@WebServlet("/student/perma-delete/*")
public class PermaDeleteStudentServlet extends HttpServlet {
    private DSLContext dsl;

    @Override
    public void init() throws ServletException {
        super.init();
        dsl = (DSLContext) getServletContext().getAttribute("dslContext");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ULong id = ULong.valueOf(req.getPathInfo().split("/")[1]);
        StudentRecord student = dsl.selectFrom(STUDENT).where(STUDENT.ID.eq(id)).fetchOne();
        if (student != null) {
            student.delete();
        }

        resp.sendRedirect(req.getContextPath() + "/students/deleted");
    }
}
