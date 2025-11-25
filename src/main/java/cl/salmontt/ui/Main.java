package cl.salmontt.ui;

import cl.salmontt.services.GestorOperaciones;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando Sistema Salmontt de Operaciones...");

        // 1. Instanciar el gestor
        GestorOperaciones gestor = new GestorOperaciones();

        // 2. Cargar datos desde CSV
        gestor.leerArchivoOperarios("nomina_operarios.csv");

        // 3. Mostrar todos los datos cargados
        gestor.listarPersonal();

        // 4. Probar filtros y lógica de negocio
        gestor.buscarPorTurno("NOCHE"); // Debería mostrar quiénes tienen bono nocturno
        gestor.buscarPorTurno("TARDE"); // Caso de prueba vacío
        }
    }