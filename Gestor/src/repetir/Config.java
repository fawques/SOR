package repetir;

import gestor_admin.AdminWS;
import jUDDI.SimplePublish;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import seguridad.InstallCert;

public class Config implements ServletContextListener {

    private ScheduledExecutorService scheduler;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new DateChecker(), 120, 60, TimeUnit.SECONDS);
        AdminWS admin =new AdminWS();
        admin.Registrar();
        scheduler.schedule(new InstallCertificado(), 5, TimeUnit.SECONDS);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        scheduler.shutdownNow();
    }

}