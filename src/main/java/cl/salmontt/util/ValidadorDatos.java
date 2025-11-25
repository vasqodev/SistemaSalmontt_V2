package cl.salmontt.util;

public class ValidadorDatos {
    public static void validarSueldoBase(int sueldo) {
        if (sueldo < 529000) {
            throw new IllegalArgumentException("El sueldo base no puede ser inferior al mínimo legal.");
        }
    }

    public static String limpiarTexto(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return "Sin información";
        }
        return texto.trim();
    }
}