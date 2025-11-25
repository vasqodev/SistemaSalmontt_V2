package cl.salmontt.services;

import cl.salmontt.model.Domicilio;
import cl.salmontt.dominio.Operario;
import cl.salmontt.util.ValidadorDatos;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorOperaciones {

    // Lista para almacenar objetos (Colección)
    private List<Operario> listaOperarios;

    public GestorOperaciones() {
        this.listaOperarios = new ArrayList<>();
    }

    public void leerArchivoOperarios(String nombreArchivo) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(nombreArchivo);

        if (is == null) {
            System.out.println("ERROR CRÍTICO: No se encontró el archivo " + nombreArchivo);
            return;
        }

        try (Scanner scanner = new Scanner(is)) {
            // Saltar encabezado si existe
            if (scanner.hasNextLine()) scanner.nextLine();

            while (scanner.hasNextLine()) {
                try {
                    String linea = scanner.nextLine();
                    String[] datos = linea.split(";"); // Usamos punto y coma como separador

                    // Extraer datos con validaciones básicas
                    String rut = ValidadorDatos.limpiarTexto(datos[0]);
                    String nombre = ValidadorDatos.limpiarTexto(datos[1]);
                    String apellido = ValidadorDatos.limpiarTexto(datos[2]);

                    // Crear objeto de composición (Domicilio)
                    String comuna = datos[3];
                    String calle = datos[4];
                    int numero = Integer.parseInt(datos[5]);
                    Domicilio dom = new Domicilio(comuna, calle, numero);

                    // Datos específicos del Operario
                    String cargo = datos[6];
                    String turno = datos[7];
                    int sueldo = Integer.parseInt(datos[8]);

                    Operario nuevoOp = new Operario(rut, nombre, apellido, dom, cargo, turno, sueldo);
                    listaOperarios.add(nuevoOp);

                } catch (NumberFormatException e) {
                    System.out.println("  >> Error de formato numérico en una línea. Se omite registro.");
                } catch (Exception e) {
                    System.out.println("  >> Error procesando operario: " + e.getMessage());
                }
            }
            System.out.println("Carga finalizada. Total registros: " + listaOperarios.size());

        } catch (Exception e) {
            System.out.println("Error general de lectura: " + e.getMessage());
        }
    }

    // Método de reporte general
    public void listarPersonal() {
        System.out.println("\n=== NOMINA DE OPERARIOS SALMONTT ===");
        for (Operario op : listaOperarios) {
            System.out.println(op);
        }
    }

    // Método de búsqueda/filtro (Requisito funcional)
    public void buscarPorTurno(String turno) {
        System.out.println("\n=== FILTRANDO POR TURNO: " + turno.toUpperCase() + " ===");
        boolean encontrado = false;
        for (Operario op : listaOperarios) {
            if (op.getTurno().equalsIgnoreCase(turno)) {
                System.out.println(" - " + op.getNombreCompleto() + " (" + op.getCargo() + ")");
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("No se encontraron operarios en este turno.");
    }
}