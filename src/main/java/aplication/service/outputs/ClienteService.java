package aplication.service.outputs;

import aplication.domain.Cliente;
import java.util.List;
import java.util.Optional;

<<<<<<< HEAD

public interface ClienteService {
    Cliente crearCliente(int id, String identificacion, String nombreCompleto,
                         String celular, String email, String usuario, String contrasena);

    Cliente actualizarCliente(int id, String identificacion, String nombreCompleto,
                              String celular, String email, String usuario, String contrasena);
    Optional<Cliente> obtenerClientePorId(int id);
    List<Cliente> obtenerTodosLosClientes();
    void eliminarCliente(int id);
    java.util.Map<Integer, Cliente> obtenerTodosLosClientesMap();
=======
public interface ClienteService {
    Cliente crearCliente(int id, String identificacion, String nombreCompleto,
                         String celular, String usuario, String contrasena);
    Cliente actualizarCliente(int id, String identificacion, String nombreCompleto,
                              String celular, String usuario, String contrasena);
    Optional<Cliente> obtenerClientePorId(int id);
    List<Cliente> obtenerTodosLosClientes();
    void eliminarCliente(int id);
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
}