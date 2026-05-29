package aplication.repository;

<<<<<<< HEAD
import aplication.configuration.DatabaseConnection;
import aplication.domain.Cliente;
import aplication.domain.Cuenta;
import aplication.persistence.mapper.ClienteRowMapper;
import aplication.persistence.mapper.CuentaAhorrosRowMapper;
import aplication.persistence.mapper.CuentaCorrienteRowMapper;
import aplication.persistence.mapper.TarjetaCreditoRowMapper;
import aplication.service.ports.AuthRepositoryPort;
import aplication.service.ports.ClienteRepositoryPort;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ClienteRepository implements ClienteRepositoryPort, AuthRepositoryPort {

    private final ClienteRowMapper clienteRowMapper = new ClienteRowMapper();
    private final CuentaAhorrosRowMapper ahorrosRowMapper = new CuentaAhorrosRowMapper();
    private final CuentaCorrienteRowMapper corrienteRowMapper = new CuentaCorrienteRowMapper();
    private final TarjetaCreditoRowMapper tarjetaRowMapper = new TarjetaCreditoRowMapper();

    private Connection getConn() throws SQLException {
        return DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public Cliente save(Cliente cliente) {
        String sql = "INSERT INTO cliente (identificacion, nombre_completo, celular, email, usuario, contrasena) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, cliente.getIdentificacion());
            ps.setString(2, cliente.getNombreCompleto());
            ps.setString(3, cliente.getCelular());
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.getUsuario());
            ps.setString(6, cliente.getContrasena());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) cliente.setId(rs.getInt(1));
            return cliente;
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar cliente: " + e.getMessage(), e);
        }
=======
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
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
    }

    @Override
    public Cliente update(int id, Cliente cliente) {
<<<<<<< HEAD
        String sql = "UPDATE cliente SET identificacion=?, nombre_completo=?, celular=?, email=?, usuario=?, contrasena=? WHERE id=?";
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setString(1, cliente.getIdentificacion());
            ps.setString(2, cliente.getNombreCompleto());
            ps.setString(3, cliente.getCelular());
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.getUsuario());
            ps.setString(6, cliente.getContrasena());
            ps.setInt(7, id);
            ps.executeUpdate();
            return cliente;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar cliente: " + e.getMessage(), e);
        }
=======
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == id) {
                clientes.set(i, cliente);
                return cliente;
            }
        }
        throw new IllegalArgumentException("Cliente con id " + id + " no encontrado.");
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
    }

    @Override
    public Optional<Cliente> findById(int id) {
<<<<<<< HEAD
        String sql = "SELECT * FROM cliente WHERE id = ?";
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Cliente cliente = clienteRowMapper.mapRow(rs);
                cliente.setCuentas(findCuentasByClienteId(id));
                return Optional.of(cliente);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar cliente por id: " + e.getMessage(), e);
        }
    }

    @Override
    public Optional<Cliente> findByUsuario(String usuario) {
        String sql = "SELECT * FROM cliente WHERE usuario = ?";
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return Optional.of(clienteRowMapper.mapRow(rs));
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar cliente por usuario: " + e.getMessage(), e);
        }
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        String sql = "UPDATE cliente SET intentos_fallidos=?, bloqueado=? WHERE id=?";
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setInt(1, cliente.getIntentosFallidos());
            ps.setBoolean(2, cliente.isBloqueado());
            ps.setInt(3, cliente.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar estado del cliente: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Cliente> findAll() {
        String sql = "SELECT * FROM cliente";
        List<Cliente> lista = new ArrayList<>();
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) lista.add(clienteRowMapper.mapRow(rs));
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar clientes: " + e.getMessage(), e);
        }
    }

    @Override
    public Map<Integer, Cliente> findAllAsMap() {
        Map<Integer, Cliente> mapa = new LinkedHashMap<>();
        for (Cliente c : findAll()) {
            mapa.put(c.getId(), c);
        }
        return mapa;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar cliente: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Cuenta> findCuentasByClienteId(int clienteId) {
        String sql = """
                SELECT c.*, cl.nombre_completo
                FROM cuenta c
                JOIN cliente cl ON c.cliente_id = cl.id
                WHERE c.cliente_id = ?
                ORDER BY c.tipo, c.numero_cuenta
                """;
        List<Cuenta> cuentas = new ArrayList<>();
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setInt(1, clienteId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                switch (rs.getString("tipo")) {
                    case "AHORROS"         -> cuentas.add(ahorrosRowMapper.mapRow(rs));
                    case "CORRIENTE"       -> cuentas.add(corrienteRowMapper.mapRow(rs));
                    case "TARJETA_CREDITO" -> cuentas.add(tarjetaRowMapper.mapRow(rs));
                }
            }
            return cuentas;
        } catch (SQLException e) {
            throw new RuntimeException("Error al cargar cuentas del cliente: " + e.getMessage(), e);
        }
=======
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
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
    }
}