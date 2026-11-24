package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import model.Cliente;
import model.Direccion;
import model.Empleado;
import model.GuiaTuristico;
import model.Persona;
import model.Rut;
import util.RutInvalidoException;

// Clase encargada de cargar los datos desde archivo y gestionar la colección
public class GestorPersonas {

    private ArrayList<Persona> listaPersonas;

    public GestorPersonas() {
        this.listaPersonas = new ArrayList<>();
    }

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    // Lee el archivo .txt línea por línea, separa por ";" y guarda los objetos en el ArrayList
    public void cargarDesdeArchivo(String rutaArchivo) {
        listaPersonas.clear();
        int numeroLinea = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo, StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                numeroLinea++;
                if (linea.trim().isEmpty()) {
                    continue;
                }

                try {
                    Persona persona = convertirLineaAPersona(linea);
                    if (persona != null) {
                        if (!existeRut(persona.getRut().getNumero())) {
                            listaPersonas.add(persona);
                        } else {
                            System.out.println("Aviso (linea " + numeroLinea + "): RUT duplicado, se omitio.");
                        }
                    }
                } catch (RutInvalidoException e) {
                    System.out.println("Error en linea " + numeroLinea + ": " + e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("Error en linea " + numeroLinea + ": dato numerico mal formado.");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Error en linea " + numeroLinea + ": faltan columnas en el archivo.");
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo '" + rutaArchivo + "': " + e.getMessage());
        }
    }

    // Convierte una línea separada por ";" en el objeto correspondiente según el tipo
    private Persona convertirLineaAPersona(String linea) throws RutInvalidoException {
        String[] datos = linea.split(";");

        String tipo = datos[0].trim().toUpperCase();
        Rut rut = new Rut(datos[1].trim());
        String nombre = datos[2].trim();
        Direccion direccion = new Direccion(
                datos[3].trim(),
                datos[4].trim(),
                datos[5].trim(),
                datos[6].trim()
        );
        String email = datos[7].trim();
        String telefono = datos[8].trim();

        if (tipo.equals("GUIA")) {
            String cargo = datos[9].trim();
            int sueldo = Integer.parseInt(datos[10].trim());
            int anioIngreso = Integer.parseInt(datos[11].trim());
            String idiomas = datos[12].trim();
            String certificacion = datos[13].trim();
            return new GuiaTuristico(rut, nombre, direccion, email, telefono,
                    cargo, sueldo, anioIngreso, idiomas, certificacion);

        } else if (tipo.equals("EMPLEADO")) {
            String cargo = datos[9].trim();
            int sueldo = Integer.parseInt(datos[10].trim());
            int anioIngreso = Integer.parseInt(datos[11].trim());
            return new Empleado(rut, nombre, direccion, email, telefono,
                    cargo, sueldo, anioIngreso);

        } else if (tipo.equals("CLIENTE")) {
            int viajes = Integer.parseInt(datos[9].trim());
            String categoria = datos[10].trim();
            return new Cliente(rut, nombre, direccion, email, telefono,
                    viajes, categoria);

        } else if (tipo.equals("PROVEEDOR")) {
            return new Persona(rut, nombre, direccion, email, telefono);
        }

        System.out.println("Tipo de registro desconocido: " + tipo);
        return null;
    }

    // Evita guardar dos personas con el mismo RUT
    private boolean existeRut(String rutNumero) {
        for (Persona p : listaPersonas) {
            if (p.getRut().getNumero().equalsIgnoreCase(rutNumero)) {
                return true;
            }
        }
        return false;
    }

    // Recorre y muestra toda la lista por consola
    public void mostrarTodas() {
        if (listaPersonas.isEmpty()) {
            System.out.println("No hay registros cargados.");
            return;
        }
        for (Persona p : listaPersonas) {
            System.out.println("- " + p);
        }
    }

    // Filtra personas por comuna
    public ArrayList<Persona> filtrarPorComuna(String comuna) {
        ArrayList<Persona> resultado = new ArrayList<>();
        for (Persona p : listaPersonas) {
            if (p.getDireccion().getComuna().equalsIgnoreCase(comuna.trim())) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    // Filtra por tipo de persona (Guía Turístico, Empleado, Cliente, Proveedor)
    public ArrayList<Persona> filtrarPorTipo(String tipoBuscado) {
        ArrayList<Persona> resultado = new ArrayList<>();
        String filtro = tipoBuscado.trim().toLowerCase().replace("í", "i");
        for (Persona p : listaPersonas) {
            String tipoPersona = p.getTipo().toLowerCase().replace("í", "i");
            if (tipoPersona.contains(filtro)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    // Búsqueda simple por nombre (coincidencia parcial)
    public ArrayList<Persona> buscarPorNombre(String nombre) {
        ArrayList<Persona> resultado = new ArrayList<>();
        String filtro = nombre.trim().toLowerCase();
        for (Persona p : listaPersonas) {
            if (p.getNombre().toLowerCase().contains(filtro)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    // Búsqueda exacta por RUT
    public Persona buscarPorRut(String rut) {
        for (Persona p : listaPersonas) {
            if (p.getRut().getNumero().equalsIgnoreCase(rut.trim())) {
                return p;
            }
        }
        return null;
    }
}
