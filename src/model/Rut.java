package model;

import util.RutInvalidoException;

public class Rut {

    private String numero;

    public Rut(String numero) throws RutInvalidoException {
        setNumero(numero);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) throws RutInvalidoException {
        if (numero == null || !numero.matches("[0-9]{7,8}-[0-9kK]")) {
            throw new RutInvalidoException("RUT invalido: " + numero + " (formato esperado: 12345678-9)");
        }
        this.numero = numero.toUpperCase();
    }

    @Override
    public String toString() {
        return numero;
    }
}
