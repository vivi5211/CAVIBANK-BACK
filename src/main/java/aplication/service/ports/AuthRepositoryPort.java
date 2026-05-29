package aplication.service.ports;

import aplication.domain.Cliente;
import java.util.Optional;

public interface AuthRepositoryPort {
    Optional<Cliente> findByUsuario(String usuario);
    void actualizarCliente(Cliente cliente);
}