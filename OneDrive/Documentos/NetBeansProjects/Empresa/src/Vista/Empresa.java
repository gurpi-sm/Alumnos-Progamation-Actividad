/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Vista;

import Model.Persona;
import Model.Empleado;
import Model.Cliente;
import Model.Vehiculo;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author gurpi
 */
public class Empresa {
    static int IDcliente = 0;
    static int IDempleado = 0;
    static int IDpersona = 0;
    static int IDmatricula = 0;
    static ArrayList<Persona> personas = new ArrayList<Persona>();
    static ArrayList<Integer> vehiculos = new ArrayList<Integer>();
    static ArrayList<String> nombres = new ArrayList<String>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        int opc = 0;
        String NNempleado = "";
        String NNcliente = "";
        int nMatricula = 0;

        //ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        //ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("--------< Bienvenido a la Empresa >--------");
            System.out.println("1.Dar de alta");
            System.out.println("2.Dar de baja");
            System.out.println("3.Modificar");
            System.out.println("4.Mostrar");
            System.out.println("5.Buscar");
            System.out.println("6.Salir");
            System.out.println("-------------------------------------------");
            System.out.println("Escoja una opción:");
            opc = sc.nextInt();

            switch (opc) {

                case 1:
                    darAlta(NNcliente, NNempleado,nMatricula);
                    IDpersona++;
                    break;

                case 2:
                    darBaja();
                    break;

                case 3:
                    modificar();
                    break;

                case 4:
                    mostrar(nMatricula);
                    break;

                case 5:
                    buscar(NNcliente, NNempleado);
                    break;

                case 6:
                    salir();
                    break;

            }

        } while (opc != 6);
    }

    public static void darAlta(String NNempleado, String NNcliente,int nMatricula) {
        Scanner sc = new Scanner(System.in);
        System.out.println("EL ID de la persona (cliente o empleado) será el siguiente:");
        System.out.println("--< " + IDpersona + " >--");
        System.out.println("-------------------------< DAR ALTA >-------------------------");
        System.out.println("¿Desea dar de alta a un cliente o a un empleado de la empresa?");
        String alta = sc.nextLine();
        
        if (alta.equalsIgnoreCase("Cliente")) {
            boolean Vip = true;
            System.out.println("Este será el ID del nuevo cliente:");
            System.out.println("--< " + IDcliente + " >--");
            System.out.println("Introduzca la fecha del registro (fecha actual):");
            String fechaCliente = sc.nextLine();
            System.out.println("¿Desea que el cliente sea VIP?");
            String vip = sc.nextLine();
            if (vip.equalsIgnoreCase("Si")) {
                Vip = true;
            } else if (vip.equalsIgnoreCase("No")) {
                Vip = false;
            }
            System.out.println("Introduzca el nombre del nuevo cliente:");
            NNcliente = sc.nextLine();
            nombres.add(NNcliente);
            System.out.println("Introduzca el género del cliente (M|F):");
            char GGcliente = sc.next().charAt(0);

            if (GGcliente != 'M' && GGcliente != 'F') {
                System.out.println("Por favor, introduzca un género válido (M|F).");
            }
            System.out.println("Introduzca la edad del cliente:");
            int EEcliente = sc.nextInt();
            sc = new Scanner(System.in);
            System.out.println("Introduzca la dirección del cliente:");
            String DDcliente = sc.nextLine();
            System.out.println("Ahora procederemos a introducir la matricula, ¿quiere añadir al cliente una matricula ya existente?");
            String existe = sc.nextLine();
            if (existe.equalsIgnoreCase("Si")) {
                while(true){
                System.out.println("En ese caso, introduzca la matricula que ya existe:");
                nMatricula = sc.nextInt();
                if (vehiculos.contains(nMatricula)){
                    System.out.println("EL ID de la matricula del cliente será el siguiente:");
                    System.out.println("--< " + nMatricula + " >--");
                    vehiculos.add(nMatricula);
                    Vehiculo vehiculo = new Vehiculo(nMatricula,NNcliente, GGcliente, EEcliente, DDcliente, IDpersona);
                    break;
                }else if(!vehiculos.contains(nMatricula)){
                    System.out.println("La matricula que ha introducido no existe.");
                }
                }
                
               
            } else if (existe.equalsIgnoreCase("No")) {
                System.out.println("EL ID de la matricula del cliente será el siguiente:");
                System.out.println("--< " + IDmatricula + " >--");
                vehiculos.add(IDmatricula);
                Vehiculo vehiculo = new Vehiculo(IDmatricula,NNcliente, GGcliente, EEcliente, DDcliente, IDpersona);
                IDmatricula++; 
            }
            
            Cliente cliente = new Cliente(IDcliente, fechaCliente, Vip, NNcliente, GGcliente, EEcliente, DDcliente, IDpersona);
            personas.add(cliente);
            IDcliente++;
            
            

        } else if (alta.equalsIgnoreCase("Empleado")) {
            System.out.println("Este será el ID del nuevo empleado:");
            System.out.println("--< " + IDempleado + " >--");
            System.out.println("Indique el sueldo establecido para el empleado:");
            double sueldo = sc.nextDouble();
            sc = new Scanner(System.in);
            System.out.println("Introduzca el nombre del nuevo empleado:");
            NNempleado = sc.nextLine();
            nombres.add(NNempleado);
            System.out.println("Introduzca el género del empleado (M|F):");
            char GGempleado = sc.next().charAt(0);

            if (GGempleado != 'M' && GGempleado != 'F') {
                System.out.println("Por favor, introduzca un género válido (M|F).");
            }
            System.out.println("Introduzca la edad del empleado:");
            int EEempleado = sc.nextInt();
            sc = new Scanner(System.in);
            System.out.println("Introduzca la dirección del empleado:");
            String DDempleado = sc.nextLine();
            
            System.out.println("Ahora procederemos a introducir la matricula, ¿quiere añadir al empleado una matricula ya existente?");
            String existe = sc.nextLine();
            if (existe.equalsIgnoreCase("Si")) {
                
                System.out.println("En ese caso, introduzca la matricula que ya existe:");
                nMatricula = sc.nextInt();
                if (vehiculos.contains(nMatricula)){
                    System.out.println("EL ID de la matricula del empleado será el siguiente:");
                    System.out.println("--< " + nMatricula + " >--");
                    vehiculos.add(nMatricula);
                    Vehiculo vehiculo = new Vehiculo(nMatricula,NNempleado, GGempleado, EEempleado, DDempleado, IDpersona);
                }else if(!vehiculos.contains(nMatricula)){
                    System.out.println("La matricula que ha introducido no existe.");
                }
                
                
            } else if (existe.equalsIgnoreCase("No")) {
                System.out.println("EL ID de la matricula del empleado será el siguiente:");
                System.out.println("--< " + IDmatricula + " >--");
                vehiculos.add(IDmatricula);
                Vehiculo vehiculo = new Vehiculo(IDmatricula,NNempleado, GGempleado, EEempleado, DDempleado, IDpersona);
                IDmatricula++; 
            }

            Empleado empleado = new Empleado(IDempleado, sueldo, NNempleado, GGempleado, EEempleado, DDempleado, IDpersona);
            personas.add(empleado);
            IDempleado++;
        }
        else {
            System.out.println("Porfavor introduzca la clase de persona que desea introducir,(Empleado | Cliente).");
        }
    }

    public static void darBaja() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el ID de la persona a la que quiere dar de baja:");
        int id1 = sc.nextInt();
        personas.remove(id1);
        personas.add(id1,null);
        nombres.remove(id1);
        nombres.add(id1,"vacio");
        System.out.println("La persona con ID <" + id1 +">, se ha dado de baja.");
        
        if (true){
            System.out.append("No se ha encontrado a una persona con tal ID, porfavor introduzca un ID que exista.");
        } else {
            System.out.println("no");
        }
    }

    
    public static void modificar() {

        int opc1 = 0;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("---------< ¿Qué desea modificar? >--------");
            System.out.println("0.Salir");
            System.out.println("1.Un cliente");
            System.out.println("2.Un empleado");
            System.out.println("-------------------------------------------");
            System.out.println("Escoja una opción:");
            opc1 = sc.nextInt();

            switch (opc1) {

                case 1:
                    modCliente();
                    break;

                case 2:
                    modEmpleado();
                    break;
            }

        } while (opc1 != 0);
    }

    public static void mostrar(int nMatricula) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Porfavor introduzca el ID de la persona que desea mostrar:");
        int id = sc.nextInt();
        if (id >= 0 && id < personas.size()&& personas.get(id)!= null) {
            System.out.print(personas.get(id));
            if (IDmatricula != -1){
                System.out.println("ID Matrícula - <" + vehiculos.get(nMatricula) + ">||");
            }else if (nMatricula != -1){
                System.out.println("ID Matrícula - <" + vehiculos.get(IDmatricula) + ">||");
            }
        } else {
            System.out.println("No existe ninguna persona con ese ID.");
        }
    }

    public static void buscar(String NNcliente, String NNempleado) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Porfavor, introduzca el nombre de la persona que desea buscar en la empresa:");
        String nBuscar = sc.nextLine();
       
        for (int i=0; i< nombres.size();i++ ) {
            if (nombres.get(i).equalsIgnoreCase("vacio")){    
            }
            else if (nombres.get(i).equalsIgnoreCase(nBuscar)){
                for (Persona persona : personas) {
                    if (persona.getName().equalsIgnoreCase(nBuscar)) {
                        System.out.println(persona);
                    }
                }
            }
        }
    
    }

    public static void salir() {
        System.out.println("Cerrando sistema de la empresa... ");
        System.out.println("El sistema se ha cerrado correctamente.");
        System.out.println("Que pase un buen día.");
    }

    public static void modCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el ID del cliente del que desea modificar la información:");
        int id1 = sc.nextInt();
        
        int opc2 = 0;

        do {
            System.out.println("---< ¿Qué desea modificar del cliente? >---");
            System.out.println("0.Salir");
            System.out.println("1.Fecha de registro");
            System.out.println("2.Tipo de cuenta cliente");
            System.out.println("3.Nombre del cliente");
            System.out.println("4.Género del cliente");
            System.out.println("5.Edad del cliente");
            System.out.println("6.Dirección del cliente");
            System.out.println("-------------------------------------------");
            System.out.println("Escoja una opción:");
            opc2 = sc.nextInt();
            sc = new Scanner(System.in);

            switch (opc2) {

                case 1: 
                    System.out.println("-< MODIFICANDO FECHA DE REGISTRO >-");
                    System.out.println("Introduzca la fecha de registro actualizada:");
                    String fecha2 = sc.nextLine();
                    ((Cliente) personas.get(id1)).setFechaRegistro(fecha2);
                    System.out.println("La fecha de registro del cliente ha sido modificada.");
                    break;

                case 2: 
                    System.out.println("---< MODIFICANDO TIPO DE CUENTA >---");
                    System.out.println("Introduzca la membresia actualizada");
                    boolean Vip  = sc.nextBoolean();
                    ((Cliente) personas.get(id1)).setVip(Vip);
                    System.out.println("La membresia ha sido actualizada");
                    break;
                
                case 3: 
                    System.out.println("-< MODIFICANDO NOMBRE DEL CLIENTE >-");
                    System.out.println("Introduzca el nombre actualizado:");
                    String nCliente = sc.nextLine();
                    ((Cliente) personas.get(id1)).setName(nCliente);
                    System.out.println("El nombre del cliente ha sido modificado.");
                    break;
                
                case 4: 
                    System.out.println("-< MODIFICANDO GÉNERO DEL CLIENTE >-");
                    System.out.println("Introduzca el género actualizado:");
                    char gCliente = sc.next().charAt(0);
                    ((Cliente) personas.get(id1)).setGender(gCliente);
                    System.out.println("El género del cliente ha sido modificado.");
                    break;
                
                case 5: 
                    System.out.println("--< MODIFICANDO EDAD DEL CLIENTE >--");
                    System.out.println("Introduzca la edad actualizada:");
                    int eCliente = sc.nextInt();
                    sc = new Scanner(System.in);
                    ((Cliente) personas.get(id1)).setAge(eCliente);
                    System.out.println("La edad del cliente ha sido modificada.");
                    break;
                
                case 6: 
                    System.out.println("-< MODIFICANDO DIRECCIÓN DEL CLIENTE >-");
                    System.out.println("Introduzca la dirección actualizada:");
                    String dCliente = sc.nextLine();
                    ((Cliente) personas.get(id1)).setDireccion(dCliente);
                    System.out.println("La dirección del cliente ha sido modificada.");
                    break;
            }

        } while (opc2 != 0);
        
    }

    public static void modEmpleado() {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el ID del empleado del que desea modificar la información:");
        int id2 = sc.nextInt();
        
        int opc3 = 0;

        do {
            System.out.println("---< ¿Qué desea modificar del empleado? >---");
            System.out.println("0.Salir");
            System.out.println("1.Sueldo del empleado");
            System.out.println("2.Nombre del empleado");
            System.out.println("3.Género del empleado");
            System.out.println("4.Edad del empleado");
            System.out.println("5.Dirección del empleado");
            System.out.println("-------------------------------------------");
            System.out.println("Escoja una opción:");
            opc3 = sc.nextInt();
            sc = new Scanner(System.in);

            switch (opc3) {

                case 1: 
                    System.out.println("---< MODIFICANDO SUELDO DEL EMPLEADO >---");
                    System.out.println("Introduzca el sueldo actualizado:");
                    double sEmpleado = sc.nextDouble();
                    sc = new Scanner(System.in);
                    ((Empleado) personas.get(id2)).setSueldo(sEmpleado);
                    System.out.println("El sueldo del empleado ha sido modificado.");
                    break;
                
                case 2: 
                    System.out.println("-< MODIFICANDO NOMBRE DEL EMPLEADO >-");
                    System.out.println("Introduzca el nombre actualizado:");
                    String nEmpleado = sc.nextLine();
                    ((Empleado) personas.get(id2)).setName(nEmpleado);
                    System.out.println("El nombre del empleado ha sido modificado.");
                    break;
                
                case 3: 
                    System.out.println("-< MODIFICANDO GÉNERO DEL EMPLEADO >-");
                    System.out.println("Introduzca el género actualizado:");
                    char gEmpleado = sc.next().charAt(0);
                    ((Empleado) personas.get(id2)).setGender(gEmpleado);
                    System.out.println("El género del empleado ha sido modificado.");
                    break;
                
                case 4: 
                    System.out.println("--< MODIFICANDO EDAD DEL EMPLEADO >--");
                    System.out.println("Introduzca la edad actualizada:");
                    int eEmpleado = sc.nextInt();
                    ((Empleado) personas.get(id2)).setAge(eEmpleado);
                    System.out.println("La edad del empleado ha sido modificada.");
                    break;
                
                case 5: 
                    System.out.println("-< MODIFICANDO DIRECCIÓN DEL EMPLEADO >-");
                    System.out.println("Introduzca la dirección actualizada:");
                    String dEmpleado = sc.nextLine();
                    ((Empleado) personas.get(id2)).setDireccion(dEmpleado);
                    System.out.println("La dirección del empleado ha sido modificada.");
                    break;
            }

        } while (opc3 != 0);
        
    }
}

