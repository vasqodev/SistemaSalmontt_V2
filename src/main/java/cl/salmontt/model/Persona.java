package cl.salmontt.model;

public abstract class Persona {
    private String rut;
    private String nombre;
    private String apellido;

    // Composición: uso de objeto Domicilio como atributo
    private Domicilio domicilio;

    public Persona(String rut, String nombre, String apellido, Domicilio domicilio) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    //Getters necesarios para encapsulamiento
    public String getRut() {
        return rut;
    }
    public Domicilio getDomicilio() {
        return domicilio;
    }

    @Override
    public String toString() {
        return String.format("RUT: %-12s | Nombre: %-20s | Domicilio: %s", rut, getNombreCompleto(), domicilio);
    }
}
