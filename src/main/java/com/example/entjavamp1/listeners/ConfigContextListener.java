package com.example.entjavamp1.listeners;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebListener
public class ConfigContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pos_db",
                    "root",
                    ""
            );
            DSLContext create = DSL.using(connection, SQLDialect.MYSQL);

            Map<String, Double> menu = new HashMap<>();
            menu.put("Chickenjoy", 82.0);
            menu.put("Jolly Spaghetti", 60.0);
            menu.put("Burger Steak", 63.0);
            menu.put("Yumburger", 40.0);
            menu.put("Chicken Sandwhich", 149.0);
            menu.put("Palabok", 138.0);

            sce.getServletContext().setAttribute("dslContext", create);
            sce.getServletContext().setAttribute("menu", menu);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}