package Practica5.Ej5;

public class Persona {
    private String nombre;
    private String tipo;
    private String domicilio;

    public Persona(String nombre, String tipo, String domicilio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.domicilio = domicilio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
}
