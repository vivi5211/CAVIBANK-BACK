package aplication.exception;

public class RecursoNoEncontradoException extends BankException {
    public RecursoNoEncontradoException(String recurso, String valor) {
        super(recurso + " no encontrado: " + valor);
    }
}