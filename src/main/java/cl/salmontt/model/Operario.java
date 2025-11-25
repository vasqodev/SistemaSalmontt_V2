package cl.salmontt.dominio;

import cl.salmontt.model.Domicilio;
import cl.salmontt.model.Persona;
import cl.salmontt.util.ValidadorDatos;

public class Operario extends Persona {
    private String cargo;
    private String turno; // "DIA" o "NOCHE"
    private int sueldoBase;

    public Operario(String rut, String nombre, String apellido, Domicilio domicilio, String cargo, String turno, int sueldoBase) {
        super(rut, nombre, apellido, domicilio);
        this.cargo = cargo;
        this.turno = turno;

        // Validación usando la clase utilitaria
        ValidadorDatos.validarSueldoBase(sueldoBase);
        this.sueldoBase = sueldoBase;
    }

    public String getCargo() { return cargo; }
    public String getTurno() { return turno; }
    public int getSueldoBase() { return sueldoBase; }

    // Lógica de negocio simple: Bono por turno de noche (20%)
    public int calcularSueldoFinal() {
        if (this.turno.equalsIgnoreCase("NOCHE")) {
            return (int) (this.sueldoBase * 1.20);
        }
        return this.sueldoBase;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format("\n   -> Cargo: %-15s | Turno: %-6s | Sueldo Liq: $%d", cargo, turno, calcularSueldoFinal());
    }
}