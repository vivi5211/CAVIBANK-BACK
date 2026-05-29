package aplication.exception;

public class CredencialesInvalidasException extends BankException {

    public CredencialesInvalidasException() {
        super("Usuario o contraseña incorrectos.");
    }
}