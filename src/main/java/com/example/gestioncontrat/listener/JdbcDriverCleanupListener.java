package com.example.gestioncontrat.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class JdbcDriverCleanupListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
                System.out.println("Deregistered JDBC driver: " + driver);
            } catch (Exception e) {
                System.err.println("Error deregistering driver: " + driver);
            }
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
    }
}
