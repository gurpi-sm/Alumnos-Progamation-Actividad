/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author gurpi
 */
public abstract class Persona {

    protected String name;
    protected char gender;
    protected int age;
    protected String direccion;
    protected int idPersona;

    public Persona(String name, char gender, int age, String direccion, int idPersona) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.direccion = direccion;
        this.idPersona = idPersona;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    
    @Override
    public String toString() {
        return name + " || " + gender + " || " + age + " || " + direccion + " || " + idPersona + " ||";
    }
}
