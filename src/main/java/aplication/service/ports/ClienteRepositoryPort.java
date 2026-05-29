package aplication.service.ports;

import aplication.domain.Cliente;
import aplication.domain.Cuenta;
import java.util.List;
import java.util.Optional;


public interface ClienteRepositoryPort {
    Cliente save(Cliente cliente);
    Cliente update(int id, Cliente cliente);
    Optional<Cliente> findById(int id);
    List<Cliente> findAll();
    void deleteById(int id);
    List<Cuenta> findCuentasByClienteId(int clienteId);
    java.util.Map<Integer, Cliente> findAllAsMap();
}

