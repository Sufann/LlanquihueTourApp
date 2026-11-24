package model;

public class Cliente extends Persona {

    private int viajesRealizados;
    private String categoria;

    public Cliente() {
        super();
        this.viajesRealizados = 0;
        this.categoria = "Nuevo";
    }

    public Cliente(Rut rut, String nombre, Direccion direccion, String email, String telefono,
                   int viajesRealizados, String categoria) {
        super(rut, nombre, direccion, email, telefono);
        setViajesRealizados(viajesRealizados);
        this.categoria = categoria;
    }

    public int getViajesRealizados() {
        return viajesRealizados;
    }

    public void setViajesRealizados(int viajesRealizados) {
        if (viajesRealizados >= 0) {
            this.viajesRealizados = viajesRealizados;
        }
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String getTipo() {
        return "Cliente";
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Viajes: " + viajesRealizados
                + " | Categoria: " + categoria;
    }
}
