package aplication.service;

import aplication.domain.Cliente;
import aplication.service.outputs.ClienteService;
import aplication.service.ports.ClienteRepositoryPort;
import java.util.List;
import java.util.Optional;
<<<<<<< HEAD
import aplication.exception.RecursoNoEncontradoException;
import aplication.exception.ReglaDeNegocioException;
=======
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460

public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepositoryPort clienteRepositoryPort;

    public ClienteServiceImpl(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

    @Override
    public Cliente crearCliente(int id, String identificacion, String nombreCompleto,
<<<<<<< HEAD
                                String celular, String email, String usuario, String contrasena) {
        Cliente cliente = new Cliente(0, identificacion, nombreCompleto,
                celular, email, usuario, contrasena);
=======
                                String celular, String usuario, String contrasena) {
        if (clienteRepositoryPort.findById(id).isPresent()) {
            throw new IllegalArgumentException("Ya existe un cliente con id: " + id);
        }
        Cliente cliente = new Cliente(id, identificacion, nombreCompleto, celular, usuario, contrasena);
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
        return clienteRepositoryPort.save(cliente);
    }

    @Override
    public Cliente actualizarCliente(int id, String identificacion, String nombreCompleto,
<<<<<<< HEAD
                                     String celular, String email, String usuario, String contrasena) {
        Cliente cliente = clienteRepositoryPort.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Cliente", String.valueOf(id)));
        cliente.setIdentificacion(identificacion);
        cliente.setNombreCompleto(nombreCompleto);
        cliente.setCelular(celular);
        cliente.setEmail(email);
=======
                                     String celular, String usuario, String contrasena) {
        Cliente cliente = clienteRepositoryPort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente con id " + id + " no encontrado."));
        cliente.setIdentificacion(identificacion);
        cliente.setNombreCompleto(nombreCompleto);
        cliente.setCelular(celular);
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
        cliente.setUsuario(usuario);
        cliente.setContrasena(contrasena);
        return clienteRepositoryPort.update(id, cliente);
    }

    @Override
    public Optional<Cliente> obtenerClientePorId(int id) {
        return clienteRepositoryPort.findById(id);
    }

    @Override
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepositoryPort.findAll();
    }

    @Override
    public void eliminarCliente(int id) {
        clienteRepositoryPort.deleteById(id);
    }
<<<<<<< HEAD

    @Override
    public java.util.Map<Integer, Cliente> obtenerTodosLosClientesMap() {
        return clienteRepositoryPort.findAllAsMap();
    }
=======
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
}
