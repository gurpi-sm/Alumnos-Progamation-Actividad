/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author gurpi
 */
public class Vehiculo extends Persona {
    
    private int matricula;

    public Vehiculo(int matricula, String name, char gender, int age, String direccion, int idPersona) {
        super(name, gender, age, direccion, idPersona);
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
   
    @Override
    public String toString() {
        return matricula + " || " + name + " || " + gender + " || " + age + " || " + direccion + " || " + idPersona + " ||";
    }

}
