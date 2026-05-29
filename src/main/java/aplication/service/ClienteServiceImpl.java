package aplication.service;

import aplication.domain.Cliente;
import aplication.service.outputs.ClienteService;
import aplication.service.ports.ClienteRepositoryPort;
import java.util.List;
import java.util.Optional;
import aplication.exception.RecursoNoEncontradoException;
import aplication.exception.ReglaDeNegocioException;

public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepositoryPort clienteRepositoryPort;

    public ClienteServiceImpl(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

    @Override
    public Cliente crearCliente(int id, String identificacion, String nombreCompleto,
                                String celular, String email, String usuario, String contrasena) {
        Cliente cliente = new Cliente(0, identificacion, nombreCompleto,
                celular, email, usuario, contrasena);
        return clienteRepositoryPort.save(cliente);
    }

    @Override
    public Cliente actualizarCliente(int id, String identificacion, String nombreCompleto,
                                     String celular, String email, String usuario, String contrasena) {
        Cliente cliente = clienteRepositoryPort.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Cliente", String.valueOf(id)));
        cliente.setIdentificacion(identificacion);
        cliente.setNombreCompleto(nombreCompleto);
        cliente.setCelular(celular);
        cliente.setEmail(email);
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

    @Override
    public java.util.Map<Integer, Cliente> obtenerTodosLosClientesMap() {
        return clienteRepositoryPort.findAllAsMap();
    }
}
