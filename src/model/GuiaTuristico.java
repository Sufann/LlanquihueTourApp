package model;

public class GuiaTuristico extends Empleado {

    private String idiomas;
    private String certificacion;

    public GuiaTuristico() {
        super();
    }

    public GuiaTuristico(Rut rut, String nombre, Direccion direccion, String email, String telefono,
                         String cargo, int sueldo, int anioIngreso,
                         String idiomas, String certificacion) {
        super(rut, nombre, direccion, email, telefono, cargo, sueldo, anioIngreso);
        this.idiomas = idiomas;
        this.certificacion = certificacion;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public String getCertificacion() {
        return certificacion;
    }

    public void setCertificacion(String certificacion) {
        this.certificacion = certificacion;
    }

    @Override
    public String getTipo() {
        return "Guia Turistico";
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Idiomas: " + idiomas
                + " | Certificacion: " + certificacion;
    }
}
