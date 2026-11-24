package model;

public class Empleado extends Persona {

    private String cargo;
    private int sueldo;
    private int anioIngreso;

    public Empleado() {
        super();
    }

    public Empleado(Rut rut, String nombre, Direccion direccion, String email, String telefono,
                    String cargo, int sueldo, int anioIngreso) {
        super(rut, nombre, direccion, email, telefono);
        this.cargo = cargo;
        setSueldo(sueldo);
        this.anioIngreso = anioIngreso;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        if (sueldo >= 0) {
            this.sueldo = sueldo;
        }
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnioIngreso(int anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

    @Override
    public String getTipo() {
        return "Empleado";
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Cargo: " + cargo
                + " | Sueldo: $" + sueldo
                + " | Ingreso: " + anioIngreso;
    }
}
