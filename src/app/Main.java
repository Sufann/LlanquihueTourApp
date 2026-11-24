package app;

import java.util.ArrayList;
import java.util.Scanner;

import model.Persona;
import service.GestorPersonas;

public class Main {

    public static void main(String[] args) {
        GestorPersonas gestor = new GestorPersonas();
        String rutaArchivo = "resources/personas.txt";

        System.out.println("=== LLANQUIHUE TOUR - GESTION DE PERSONAS ===");
        System.out.println("Cargando datos desde: " + rutaArchivo);
        gestor.cargarDesdeArchivo(rutaArchivo);
        System.out.println("Registros cargados correctamente: " + gestor.getListaPersonas().size());

        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Mostrar todas las personas");
            System.out.println("2. Filtrar por comuna");
            System.out.println("3. Filtrar por tipo (Guia, Empleado, Cliente, Proveedor)");
            System.out.println("4. Buscar por nombre");
            System.out.println("5. Buscar por RUT");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingresa un numero valido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n--- LISTADO COMPLETO ---");
                    gestor.mostrarTodas();
                    break;

                case 2:
                    System.out.print("Ingresa la comuna (ej. Puerto Varas, Llanquihue, Frutillar): ");
                    String comuna = scanner.nextLine();
                    mostrarResultados(gestor.filtrarPorComuna(comuna));
                    break;

                case 3:
                    System.out.print("Ingresa el tipo (ej. guia, empleado, cliente, proveedor): ");
                    String tipo = scanner.nextLine();
                    mostrarResultados(gestor.filtrarPorTipo(tipo));
                    break;

                case 4:
                    System.out.print("Ingresa nombre o parte del nombre: ");
                    String nombre = scanner.nextLine();
                    mostrarResultados(gestor.buscarPorNombre(nombre));
                    break;

                case 5:
                    System.out.print("Ingresa el RUT (ej. 12345678-9): ");
                    String rut = scanner.nextLine();
                    Persona encontrada = gestor.buscarPorRut(rut);
                    if (encontrada != null) {
                        System.out.println("\nResultado encontrado:");
                        System.out.println("- " + encontrada);
                    } else {
                        System.out.println("No se encontro ninguna persona con el RUT: " + rut);
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion no valida. Intenta nuevamente.");
                    break;
            }
        }

        scanner.close();
    }

    private static void mostrarResultados(ArrayList<Persona> lista) {
        System.out.println("\nResultados encontrados: " + lista.size());
        if (lista.isEmpty()) {
            System.out.println("No hubo coincidencias.");
            return;
        }
        for (Persona p : lista) {
            System.out.println("- " + p);
        }
    }
}
