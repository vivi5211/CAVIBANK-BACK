package aplication.service.outputs;

import aplication.domain.Cliente;
import java.util.List;
import java.util.Optional;

public interface ClienteService {
    Cliente crearCliente(int id, String identificacion, String nombreCompleto,
                         String celular, String usuario, String contrasena);
    Cliente actualizarCliente(int id, String identificacion, String nombreCompleto,
                              String celular, String usuario, String contrasena);
    Optional<Cliente> obtenerClientePorId(int id);
    List<Cliente> obtenerTodosLosClientes();
    void eliminarCliente(int id);
}