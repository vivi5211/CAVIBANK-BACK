package aplication.exception;

public class ReglaDeNegocioException extends BankException {
    public ReglaDeNegocioException(String mensaje) {
        super(mensaje);
    }
}