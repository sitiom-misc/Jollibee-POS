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

import static com.example.entjavame2.model.Tables.STUDENT;

@WebServlet("/student/update/*")
public class UpdateStudentServlet extends HttpServlet {
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
        req.setAttribute("student", student);
        getServletContext().getRequestDispatcher("/WEB-INF/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ULong id = ULong.valueOf(req.getPathInfo().split("/")[1]);
        String name = req.getParameter("name");
        String section = req.getParameter("section");
        int exam1 = Integer.parseInt(req.getParameter("exam1"));
        int exam2 = Integer.parseInt(req.getParameter("exam2"));
        Double average = (exam1 + exam2) / 2.0;

        dsl.update(STUDENT).set(STUDENT.NAME, name)
                .set(STUDENT.SECTION, section)
                .set(STUDENT.EXAM1, exam1)
                .set(STUDENT.EXAM2, exam2)
                .set(STUDENT.AVERAGE, average)
                .where(STUDENT.ID.eq(id))
                .execute();

        resp.sendRedirect(req.getContextPath() + "/students");
    }
}
