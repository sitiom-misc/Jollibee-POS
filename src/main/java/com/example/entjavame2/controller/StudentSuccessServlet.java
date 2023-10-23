package com.example.entjavame2.controller;


import com.example.entjavame2.model.Tables;
import com.example.entjavame2.model.tables.records.StudentRecord;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;

@WebServlet("/success")
public class StudentSuccessServlet extends HttpServlet {
    private DSLContext dsl;

    @Override
    public void init() throws ServletException {
        super.init();
        dsl = (DSLContext) getServletContext().getAttribute("dslContext");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String section = req.getParameter("section");
        int exam1 = Integer.parseInt(req.getParameter("exam1"));
        int exam2 = Integer.parseInt(req.getParameter("exam2"));
        Double average = (exam1 + exam2) / 2.0;

        StudentRecord newStudent = dsl.newRecord(Tables.STUDENT);
        newStudent.setName(name);
        newStudent.setSection(section);
        newStudent.setExam1(exam1);
        newStudent.setExam2(exam2);
        newStudent.setAverage(average);
        newStudent.store();

        req.setAttribute("message", "New student added!");
        req.setAttribute("student", newStudent);

        getServletContext().getRequestDispatcher("/WEB-INF/success.jsp").forward(req, resp);
    }
}
