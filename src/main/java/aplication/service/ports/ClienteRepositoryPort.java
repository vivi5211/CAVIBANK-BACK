package aplication.service.ports;

import aplication.domain.Cliente;
<<<<<<< HEAD
import aplication.domain.Cuenta;
import java.util.List;
import java.util.Optional;


=======
import java.util.List;
import java.util.Optional;

>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
public interface ClienteRepositoryPort {
    Cliente save(Cliente cliente);
    Cliente update(int id, Cliente cliente);
    Optional<Cliente> findById(int id);
    List<Cliente> findAll();
    void deleteById(int id);
<<<<<<< HEAD
    List<Cuenta> findCuentasByClienteId(int clienteId);
    java.util.Map<Integer, Cliente> findAllAsMap();
}

=======
}
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
