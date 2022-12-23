package org.example.Main;

import org.example.Servicios.ServiciosCliente;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ServiciosCliente sc = (ServiciosCliente) context.getBean("serviciosCliente");
        sc.menu();

    }

}
