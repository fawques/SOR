package repetir;

import gestor_admin.AdminWS;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import audit.AuditLogger;

public class Config implements ServletContextListener {

    private ScheduledExecutorService scheduler;

    @Override
    public void contextInitialized(ServletContextEvent event) {
    	AuditLogger.setUser("GESTOR_USER");
        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new DateChecker(), 120, 60, TimeUnit.SECONDS);
        AdminWS admin =new AdminWS();
        admin.Registrar();
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        scheduler.shutdownNow();
    }

}