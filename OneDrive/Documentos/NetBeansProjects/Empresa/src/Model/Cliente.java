/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author gurpi
 */
public class Cliente extends Persona {

    private int idCliente;
    private String fechaRegistro;
    private boolean vip;

    public Cliente(int idCliente, String fechaRegistro, boolean vip, String name, char gender, int age, String direccion, int idPersona) {
        super(name, gender, age, direccion, idPersona);
        this.idCliente = idCliente;
        this.fechaRegistro = fechaRegistro;
        this.vip = vip;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        return "|| ID cliente - <" +idCliente + "> || Fecha Registro - <" + fechaRegistro + "> || " + "¿ES VIP? --> " + vip + " || Nombre cliente - <" + name + "> || Género cliente - <" + gender + "> || Edad cliente - <" + age + "> || "
                + "Dirección cliente - <" + direccion + "> || ID persona - <" + idPersona + "> ||";
    }
}
