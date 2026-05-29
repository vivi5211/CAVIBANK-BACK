package aplication.repository;

<<<<<<< HEAD
import aplication.configuration.DatabaseConnection;
import aplication.domain.CuentaAhorros;
import aplication.persistence.mapper.CuentaAhorrosRowMapper;
import aplication.service.ports.CuentaAhorrosRepositoryPort;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CuentaAhorrosRepository implements CuentaAhorrosRepositoryPort {

    private final CuentaAhorrosRowMapper rowMapper = new CuentaAhorrosRowMapper();

    private Connection getConn() throws SQLException {
        return DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public CuentaAhorros save(CuentaAhorros cuenta) {
        String sql = "INSERT INTO cuenta (numero_cuenta, tipo, saldo, fecha_apertura, estado, cliente_id, tasa_interes) VALUES (?, 'AHORROS', ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setString(1, cuenta.getNumeroCuenta());
            ps.setDouble(2, cuenta.getSaldo());
            ps.setTimestamp(3, Timestamp.valueOf(cuenta.getFechaApertura()));
            ps.setString(4, cuenta.getEstado().name());
            ps.setInt(5, cuenta.getClienteId());
            ps.setDouble(6, cuenta.getTasaInteres());
            ps.executeUpdate();
            return cuenta;
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar cuenta de ahorros: " + e.getMessage(), e);
        }
=======
import aplication.domain.CuentaAhorros;
import aplication.domain.enums.EstadoCuenta;
import aplication.service.ports.CuentaAhorrosRepositoryPort;
import java.time.LocalDateTime;
import java.util.*;

public class CuentaAhorrosRepository implements CuentaAhorrosRepositoryPort {

    private final List<CuentaAhorros> cuentas = new ArrayList<>(Arrays.asList(
            new CuentaAhorros("AH-001", 5000000, LocalDateTime.now(), EstadoCuenta.ACTIVA, 3.5),
            new CuentaAhorros("AH-002", 1200000, LocalDateTime.now(), EstadoCuenta.ACTIVA, 3.5)
    ));

    @Override
    public CuentaAhorros save(CuentaAhorros cuenta) {
        cuentas.add(cuenta);
        return cuenta;
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
    }

    @Override
    public CuentaAhorros update(String numeroCuenta, CuentaAhorros cuenta) {
<<<<<<< HEAD
        String sql = "UPDATE cuenta SET saldo=?, estado=?, tasa_interes=? WHERE numero_cuenta=? AND tipo='AHORROS'";
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setDouble(1, cuenta.getSaldo());
            ps.setString(2, cuenta.getEstado().name());
            ps.setDouble(3, cuenta.getTasaInteres());
            ps.setString(4, numeroCuenta);
            ps.executeUpdate();
            return cuenta;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar cuenta de ahorros: " + e.getMessage(), e);
        }
=======
        for (int i = 0; i < cuentas.size(); i++) {
            if (cuentas.get(i).getNumeroCuenta().equals(numeroCuenta)) {
                cuentas.set(i, cuenta);
                return cuenta;
            }
        }
        throw new IllegalArgumentException("Cuenta de ahorros " + numeroCuenta + " no encontrada.");
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
    }

    @Override
    public Optional<CuentaAhorros> findByNumeroCuenta(String numeroCuenta) {
<<<<<<< HEAD
        String sql = "SELECT c.*, cl.nombre_completo FROM cuenta c JOIN cliente cl ON c.cliente_id = cl.id WHERE c.numero_cuenta = ? AND c.tipo = 'AHORROS'";
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setString(1, numeroCuenta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return Optional.of(rowMapper.mapRow(rs));
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar cuenta de ahorros: " + e.getMessage(), e);
        }
    }

    @Override
    public List<CuentaAhorros> findAll() {
        String sql = "SELECT c.*, cl.nombre_completo FROM cuenta c JOIN cliente cl ON c.cliente_id = cl.id WHERE c.tipo = 'AHORROS'";
        List<CuentaAhorros> lista = new ArrayList<>();
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) lista.add(rowMapper.mapRow(rs));
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar cuentas de ahorros: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteByNumeroCuenta(String numeroCuenta) {
        String sql = "DELETE FROM cuenta WHERE numero_cuenta = ? AND tipo = 'AHORROS'";
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setString(1, numeroCuenta);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar cuenta de ahorros: " + e.getMessage(), e);
        }
    }
}
=======
        for (CuentaAhorros c : cuentas)
            if (c.getNumeroCuenta().equals(numeroCuenta)) return Optional.of(c);
        return Optional.empty();
    }

    @Override
    public List<CuentaAhorros> findAll() { return cuentas; }

    @Override
    public void deleteByNumeroCuenta(String numeroCuenta) {
        boolean removed = cuentas.removeIf(c -> c.getNumeroCuenta().equals(numeroCuenta));
        System.out.println(removed ? "Cuenta eliminada." : "Cuenta no encontrada.");
    }
}
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
