package me.belk;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce){
        System.out.println("MyListener.contextInitialized");
        sce.getServletContext().setAttribute("name", "belk");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce){
        System.out.println("MyListener.contextDestroyed");
    }
}
