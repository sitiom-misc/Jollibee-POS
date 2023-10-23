package com.example.entjavame2.listeners;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class ConfigContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/iacademy",
                    "root",
                    ""
            );
            DSLContext create = DSL.using(connection, SQLDialect.MYSQL);

            sce.getServletContext().setAttribute("dslContext", create);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}