/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

/**
 *
 * @author gurpi
 */
import java.io.*;
import java.util.*;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import Clases.Alumno;

public class Alumnos {
    private static final String ARCHIVO = "registro2.txt";
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        int opc;
        do {
            System.out.println("------------ GESTIÓN DE ALUMNOS -----------");
            System.out.println("1. Agregar alumno");
            System.out.println("2. Mostrar lista");
            System.out.println("3. Eliminar alumno por DNI");
            System.out.println("4. Buscar alumno por DNI");
            System.out.println("5. Salir");
            System.out.println("--------------------------------------------");
            System.out.println("Seleccione una opción: ");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                
                case 1 : añadirAlumno();
                break;
                
                case 2 : mostrarAlumnos();
                break;
                
                case 3 : eliminarAlumno();
                break;
                
                case 4 : buscarAlumno();
                break;
                
                case 5 : salir();
                        break;
            }
        } while (opc != 5);
    }

    private static void añadirAlumno() {
        System.out.println("Ingrese el nombre del alumno que se está registrando:"); 
        String nom = sc.nextLine();
        System.out.println("Ingrese el apellido del alumno que se está registrando:"); 
        String apellido = sc.nextLine();
        System.out.println("Ingrese la edad del alumno que se está registrando:"); 
        int edad = sc.nextInt(); 
        sc.nextLine();
        System.out.println("Ingrese el curso del alumno que se está registrando: "); 
        String curso = sc.nextLine();
        System.out.println("Ingrese el DNI del alumno que se está registrando: "); 
        String dni = sc.nextLine();
 
        if (existeDni(dni)) {
            System.out.println("Error: Ya existe un alumno con ese DNI.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
            Alumno alumno = new Alumno(nom, apellido, edad, curso, dni);
            bw.write(alumno.toString());
            bw.newLine();
            System.out.println("Alumno se ha registrado con éxito.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    private static void mostrarAlumnos() {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            System.out.println("LISTADO DE ALUMNOS:");
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                System.out.printf("DNI: %s | %s %s | Edad: %s | Curso: %s%n", 
                                  datos[4], datos[0], datos[1], datos[2], datos[3]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No hay ningún alumno registrado por el momento.");
        } catch (IOException e) {
            System.out.println("ERROR | No se ha podido leer el archivo del registro.");
        }
    }

    private static void buscarAlumno() {
        System.out.print("Ingrese DNI del alumno que está buscando: ");
        String dniBusqueda = sc.nextLine();
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.contains(dniBusqueda)) {
                    System.out.println("Datos del alumno con dni " + dniBusqueda + " : " + linea);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) System.out.println("El alumno de DNI " + dniBusqueda + " no se ha encontrado.");
        } catch (IOException e) {
            System.out.println("ERROR | No se ha podido ejecutar la búsqueda.");
        }
    }

    private static void eliminarAlumno() {
        mostrarAlumnos();
        System.out.println("Ingrese el DNI del alumno que desea eliminar: ");
        String dniEliminar = sc.nextLine();
        File archivoOriginal = new File(ARCHIVO);
        File archivoTemporal = new File("temp.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
             BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTemporal))) {
            
            String linea;
            boolean borrado = false;
            while ((linea = br.readLine()) != null) {
                if (!linea.endsWith(dniEliminar)) {
                    bw.write(linea);
                    bw.newLine();
                } else {
                    borrado = true;
                }
            }
            
            if (borrado) {
                System.out.println("El alumno ha sido eliminado correctamente.");
            }
        } catch (IOException e) {
            System.out.println("ERROR | No se ha podido eliminar al alumno.");
        }
        
        archivoOriginal.delete();
        archivoTemporal.renameTo(archivoOriginal);
    }

    private static boolean existeDni(String dni) {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.endsWith(dni)) 
                    return true;
            }
        } catch (IOException e) { 
            return false; 
        }
        return false;
    }
    
    public static void salir(){
        
    }
}
