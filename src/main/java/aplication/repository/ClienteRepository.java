package aplication.repository;

import aplication.domain.Cliente;
import aplication.service.ports.ClienteRepositoryPort;
import java.util.*;

public class ClienteRepository implements ClienteRepositoryPort {

    private final List<Cliente> clientes = new ArrayList<>(Arrays.asList(
            new Cliente(1, "1001234567", "Ana Torres", "3001234567", "ana123", "clave123"),
            new Cliente(2, "1009876543", "Luis Pérez", "3109876543", "luis456", "clave456")
    ));

    @Override
    public Cliente save(Cliente cliente) {
        clientes.add(cliente);
        return cliente;
    }

    @Override
    public Cliente update(int id, Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == id) {
                clientes.set(i, cliente);
                return cliente;
            }
        }
        throw new IllegalArgumentException("Cliente con id " + id + " no encontrado.");
    }

    @Override
    public Optional<Cliente> findById(int id) {
        for (Cliente c : clientes)
            if (c.getId() == id) return Optional.of(c);
        return Optional.empty();
    }

    @Override
    public List<Cliente> findAll() { return clientes; }

    @Override
    public void deleteById(int id) {
        boolean removed = clientes.removeIf(c -> c.getId() == id);
        System.out.println(removed ? "Cliente eliminado." : "Cliente no encontrado.");
    }
}