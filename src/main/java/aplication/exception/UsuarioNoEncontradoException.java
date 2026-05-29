package aplication.exception;

public class UsuarioNoEncontradoException extends BankException {

    public UsuarioNoEncontradoException(String usuario) {
        super("No existe un cliente con el usuario: " + usuario);
    }
}