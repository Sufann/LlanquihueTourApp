package util;

// Excepción propia para avisar cuando un RUT no tiene el formato correcto
public class RutInvalidoException extends Exception {

    public RutInvalidoException(String mensaje) {
        super(mensaje);
    }
}
