/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author gurpi
 */
public class Empleado extends Persona {

    private int idEmpleado;
    private double sueldo;

    public Empleado(int idEmpleado, double sueldo, String name, char gender, int age, String direccion, int idPersona) {
        super(name, gender, age, direccion, idPersona);
        this.idEmpleado = idEmpleado;
        this.sueldo = sueldo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
     @Override
    public String toString() {
        return "|| ID empleado - <" +idEmpleado + "> || Sueldo empleado - <" + sueldo + "> || Nombre empleado - <"  + name + "> || Género empleado - <" + gender + "> || Edad empleado - <" + age + "> || "
                + "Dirección empleado - <" + direccion + "> || ID persona - <" + idPersona + "> ||";
    }
}

