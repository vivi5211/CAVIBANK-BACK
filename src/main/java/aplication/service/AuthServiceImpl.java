package aplication.service;

import aplication.domain.Cliente;
import aplication.exception.CredencialesInvalidasException;
import aplication.exception.CuentaBloqueadaException;
import aplication.exception.UsuarioNoEncontradoException;
import aplication.service.outputs.AuthService;
import aplication.service.ports.AuthRepositoryPort;
import aplication.session.ClienteSession;

public class AuthServiceImpl implements AuthService {

    private final AuthRepositoryPort authRepositoryPort;
    private final ClienteSession sesion;

    public AuthServiceImpl(AuthRepositoryPort authRepositoryPort) {
        this.authRepositoryPort = authRepositoryPort;
        this.sesion = ClienteSession.getInstance();
    }

    @Override
    public Cliente login(String usuario, String contrasena) {

        Cliente cliente = authRepositoryPort.findByUsuario(usuario)
                .orElseThrow(() -> new UsuarioNoEncontradoException(usuario));

        if (cliente.isBloqueado()) {
            throw new CuentaBloqueadaException();
        }

        if (!cliente.autenticar(usuario, contrasena)) {
            cliente.incrementarIntentos();
            authRepositoryPort.actualizarCliente(cliente);
            throw new CredencialesInvalidasException();
        }

        cliente.resetearIntentos();
        authRepositoryPort.actualizarCliente(cliente);
        sesion.iniciarSesion(cliente);
        return cliente;
    }

    @Override
    public void logout() {
        sesion.cerrarSesion();
        System.out.println("Sesión cerrada correctamente.");
    }
}