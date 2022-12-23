package org.example.Servicios;

import org.example.Entidades.Cliente;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Scanner;

public class ServiciosCliente {
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private ArrayList<Cliente> nuevosClientes = new ArrayList<>();

    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    public void menu() {
        Scanner leer = new Scanner(System.in);
        int opcion;
        usuariosClientes();

        do {
            System.out.println("Bienvenido al Banco Roma");
            System.out.println("En que podemos ayudarlo?");
            System.out.println("Opcion 1: crear cuenta");
            System.out.println("Opcion 2: ingresar a mi cuenta");
            System.out.println("Opcion 3: Quiero salir");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Entendido, vamos a necesitar los siguietes datos para crear su cuenta: ");
                    if (esValido()) {
                        guardarClientes();}
                    break;
                case 2:
                    System.out.println("Por favor ingrese su usuario y luego su contraseña");
                    validarCuenta();

                    break;
                case 3:
                    System.out.println("De acuerdo, nos vemos!");
                    break;
                default:
                    System.out.println("Esa opcion no es correcta por lo tanto vas a salir de la pagina del banco");
                    break;
            }

        } while (opcion != 3);
    }

    public  boolean esValido() {
        boolean resultado = false;
        int edad;
        try{
            System.out.println("Ingresar edad");
            edad = leer.nextInt();
            if (edad >= 18 && edad<=110) {
                resultado = true;
                System.out.println("Perfecto, vamos a necesitar unos datos mas para crear tu cuenta:");
            } else {
                System.out.println("Lo sentimos pero no puede crear una cuenta ya que su edad no cumple el requisito necesario para crear una cuenta");
            }
        } catch (Exception e){
            System.out.println("La edad ingresada no es correcta, por favor intente nuevamente");
            leer.next();
        }
        return resultado;
    }

    public  Cliente crearCliente() {
        boolean validarDatos = true;
        do{
            try {
                Cliente cliente = (Cliente) context.getBean("cliente");
                System.out.println("Ingresar nombre");
                cliente.setNombre(leer.next());
                System.out.println("Ingrese su apellido");
                cliente.setApellido(leer.next());
                System.out.println("Por favor valide su edad nuevamente");
                cliente.setEdad(leer.nextInt());
                System.out.println("Ingrese la direccion de su domicilio");
                cliente.setDireccion(leer.next());
                System.out.println("Ingrese su numero de celular");
                cliente.setNumeroCelular(leer.nextInt());
                System.out.println("Ingrese su correo");
                cliente.setCorreo(leer.next());
                System.out.println("Ingrese su usuario");
                cliente.setUsuario(leer.next());
                System.out.println("Ingrese su clave");
                cliente.setClave(leer.next());
                System.out.println("Ingrese el monto que va a depositar");
                cliente.setMontoTarjeta(leer.nextInt());
                validarDatos = true;
                System.out.println("El usuario se creo correctamente");
                return cliente;

            } catch (Exception e){
                System.out.println("Se encontro un error de sintaxis a la hora de completar los datos, por favor intete de nuevo");
                leer.next();
            }
        } while (!validarDatos);
        return null;
    }

    public  void usuariosClientes() {
        nuevosClientes.add(new Cliente("Rosana", "Ferrari", 45, "Buenos Aires", 1189458713,
                "rosanaFerrari@gmail.com", 478445789, 01, "rosana2022", "rosanaferrari", 450));
        nuevosClientes.add(new Cliente("Alejandro", "Beatriz", 30, "Catamarca", 1113124789,
                "alejandro_beatriz@gmail.com", 454678945, 02, "alejandro30", "ale2022", 1000));
        nuevosClientes.add(new Cliente("Carlos", "Rodriguez", 57, "San Juan", 1156748142,
                "carlosrodriguez@gmail.com", 445789, 01, "carlos_2021", "carlos1968", 1200));
    }

    public  void guardarClientes() {
        Cliente cliente = crearCliente();
        nuevosClientes.add(cliente);
    }

    public  void validarCuenta() {
        System.out.println("Ingrese su usuario");
        String usuario = leer.next();
        System.out.println("Por favor ingrese su clave");
        String clave = leer.next();
        for (Cliente clientes : nuevosClientes) {
            if (clientes.getUsuario().equals(usuario)) {
                if (clientes.getClave().equals(clave)) {
                    System.out.println("Bievenido a su cuenta");
                    tipoMovimiento(clientes);
                }
            }
        }
    }

    public  void tipoMovimiento(Cliente c) {
        Integer movimiento;
        do {

            System.out.println("Seleccione la opcion de movimiento que desea realizar");
            System.out.println("Opcion 1: Hacer un deposito");
            System.out.println("Opcion 2: Hacer una transferencia");
            System.out.println("Opcion 3: Extraer dinero");
            System.out.println("Opcion 4: Consultar dinero en cuenta");
            System.out.println("Opcion 5: Quiero volver al menu");
            movimiento = leer.nextInt();
            switch (movimiento) {
                case 1:
                    System.out.println("Cuanto dinero quiere depositar?");
                    depositarDinero(c);
                    break;
                case 2:
                    System.out.println("Coloque el usuario al que le quiere hacer la transferencia?");
                    transferirDinero(c);
                    break;
                case 3:
                    System.out.println("Cuanto dinero quiere extrar?");
                    extraerDinero(c);
                    break;
                case 4:
                    System.out.println("Consultar dinero en cuenta");
                    consultarDinero(c);
                    break;
                case 5:
                    System.out.println("Volver al menu principal");
                    break;
                default:
                    System.out.println("Lo siento esa no es una opcion correcta por lo que vas a volver a menu usuario");
                    break;
            }
        } while (movimiento != 5);

    }

    public  void depositarDinero(Cliente cliente) {
        Integer dinero;
        dinero = leer.nextInt();
        cliente.setMontoTarjeta((cliente.getMontoTarjeta() + dinero));
        System.out.println("El dinero actual de la cuenta es " + cliente.getMontoTarjeta());
        tipoMovimiento(cliente);
    }

    public  void transferirDinero(Cliente cliente) {
        String aliasUsuario = leer.next();
        System.out.println("Cual es el monto que desea transferir?");
        Integer monto = leer.nextInt();
        if (monto > cliente.getMontoTarjeta()) {
            System.out.println("No tiene el monto suficiente");
        } else {
            for (Cliente c : nuevosClientes)
                if (aliasUsuario.equals(c.getUsuario())) {
                    cliente.setMontoTarjeta(cliente.getMontoTarjeta() - monto);
                    c.setMontoTarjeta(c.getMontoTarjeta() + monto);
                    System.out.println("El dinero fue transferido, saldo actual: " + cliente.getMontoTarjeta());
                }
        }

    }

    public  void extraerDinero(Cliente cliente) {
        Integer dinero;
        dinero = leer.nextInt();
        cliente.setMontoTarjeta(cliente.getMontoTarjeta() - dinero);
        System.out.println("El dinero actual de la cuenta es " + cliente.getMontoTarjeta());
    }

    public void consultarDinero (Cliente cliente){
        System.out.println("El dinero actual de la cuenta es de: " + cliente.getMontoTarjeta());
    }
}
