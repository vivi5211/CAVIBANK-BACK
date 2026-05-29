package aplication.exception;

public class CuentaBloqueadaException extends BankException {

    public CuentaBloqueadaException() {
        super("La cuenta está bloqueada por demasiados intentos fallidos. Contacte al banco.");
    }
}