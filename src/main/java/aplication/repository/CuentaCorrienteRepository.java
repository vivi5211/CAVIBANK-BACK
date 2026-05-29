package aplication.repository;

import aplication.configuration.DatabaseConnection;
import aplication.domain.CuentaCorriente;
import aplication.persistence.mapper.CuentaCorrienteRowMapper;
import aplication.service.ports.CuentaCorrienteRepositoryPort;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CuentaCorrienteRepository implements CuentaCorrienteRepositoryPort {

    private final CuentaCorrienteRowMapper rowMapper = new CuentaCorrienteRowMapper();

    private Connection getConn() throws SQLException {
        return DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public CuentaCorriente save(CuentaCorriente cuenta) {
        String sql = "INSERT INTO cuenta (numero_cuenta, tipo, saldo, fecha_apertura, estado, cliente_id, porcentaje_sobregiro, limite_sobregiro) VALUES (?, 'CORRIENTE', ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setString(1, cuenta.getNumeroCuenta());
            ps.setDouble(2, cuenta.getSaldo());
            ps.setTimestamp(3, Timestamp.valueOf(cuenta.getFechaApertura()));
            ps.setString(4, cuenta.getEstado().name());
            ps.setInt(5, cuenta.getClienteId());
            ps.setDouble(6, cuenta.getPorcentajeSobregiro());
            ps.setDouble(7, cuenta.getLimiteSobregiro());
            ps.executeUpdate();
            return cuenta;
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar cuenta corriente: " + e.getMessage(), e);
        }
    }

    @Override
    public CuentaCorriente update(String numeroCuenta, CuentaCorriente cuenta) {
        String sql = "UPDATE cuenta SET saldo=?, estado=?, porcentaje_sobregiro=?, limite_sobregiro=? WHERE numero_cuenta=? AND tipo='CORRIENTE'";
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setDouble(1, cuenta.getSaldo());
            ps.setString(2, cuenta.getEstado().name());
            ps.setDouble(3, cuenta.getPorcentajeSobregiro());
            ps.setDouble(4, cuenta.getLimiteSobregiro());
            ps.setString(5, numeroCuenta);
            ps.executeUpdate();
            return cuenta;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar cuenta corriente: " + e.getMessage(), e);
        }
    }

    @Override
    public Optional<CuentaCorriente> findByNumeroCuenta(String numeroCuenta) {
        String sql = "SELECT c.*, cl.nombre_completo FROM cuenta c JOIN cliente cl ON c.cliente_id = cl.id WHERE c.numero_cuenta = ? AND c.tipo = 'CORRIENTE'";
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setString(1, numeroCuenta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return Optional.of(rowMapper.mapRow(rs));
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar cuenta corriente: " + e.getMessage(), e);
        }
    }

    @Override
    public List<CuentaCorriente> findAll() {
        String sql = "SELECT c.*, cl.nombre_completo FROM cuenta c JOIN cliente cl ON c.cliente_id = cl.id WHERE c.tipo = 'CORRIENTE'";
        List<CuentaCorriente> lista = new ArrayList<>();
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) lista.add(rowMapper.mapRow(rs));
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar cuentas corrientes: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteByNumeroCuenta(String numeroCuenta) {
        String sql = "DELETE FROM cuenta WHERE numero_cuenta = ? AND tipo = 'CORRIENTE'";
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setString(1, numeroCuenta);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar cuenta corriente: " + e.getMessage(), e);
        }
    }
}