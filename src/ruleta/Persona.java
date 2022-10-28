/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ruleta;

/**
 *
 * @author estef
 */
public class Persona {
    private String Nombre, Apellido, Cedula;
    private Integer Edad;

    public Persona() {}

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getCedula() {
        return Cedula;
    }

    public Integer getEdad() {
        return Edad;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public void setEdad(Integer Edad) {
        this.Edad = Edad;
    }
    
    
    
    
}
