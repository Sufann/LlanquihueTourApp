package model;

// Clase base para las personas vinculadas a la agencia
// Usa composición con Rut y Direccion
public class Persona {

    private Rut rut;
    private String nombre;
    private Direccion direccion;
    private String email;
    private String telefono;

    public Persona() {
        this.direccion = new Direccion();
    }

    public Persona(Rut rut, String nombre, Direccion direccion, String email, String telefono) {
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
    }

    public Rut getRut() {
        return rut;
    }

    public void setRut(Rut rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre.trim();
        }
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo() {
        return "Proveedor / Contacto";
    }

    @Override
    public String toString() {
        return "[" + getTipo() + "] " + nombre
                + " | RUT: " + rut
                + " | Dir: " + direccion
                + " | Email: " + email
                + " | Tel: " + telefono;
    }
}
