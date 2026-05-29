package aplication.repository;

import aplication.configuration.DatabaseConnection;
import aplication.domain.TarjetaCredito;
import aplication.persistence.mapper.TarjetaCreditoRowMapper;
import aplication.service.ports.TarjetaCreditoRepositoryPort;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TarjetaCreditoRepository implements TarjetaCreditoRepositoryPort {

    private final TarjetaCreditoRowMapper rowMapper = new TarjetaCreditoRowMapper();

    private Connection getConn() throws SQLException {
        return DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public TarjetaCredito save(TarjetaCredito tarjeta) {
        String sql = "INSERT INTO cuenta (numero_cuenta, tipo, saldo, fecha_apertura, estado, cliente_id, cupo, deuda, numero_cuotas) VALUES (?, 'TARJETA_CREDITO', ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setString(1, tarjeta.getNumeroCuenta());
            ps.setDouble(2, tarjeta.getSaldo());
            ps.setTimestamp(3, Timestamp.valueOf(tarjeta.getFechaApertura()));
            ps.setString(4, tarjeta.getEstado().name());
            ps.setInt(5, tarjeta.getClienteId());
            ps.setDouble(6, tarjeta.getCupo());
            ps.setDouble(7, tarjeta.getDeuda());
            ps.setInt(8, tarjeta.getNumeroCuotas());
            ps.executeUpdate();
            return tarjeta;
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar tarjeta de crédito: " + e.getMessage(), e);
        }
    }

    @Override
    public TarjetaCredito update(String numeroCuenta, TarjetaCredito tarjeta) {
        String sql = "UPDATE cuenta SET saldo=?, estado=?, cupo=?, deuda=?, numero_cuotas=? WHERE numero_cuenta=? AND tipo='TARJETA_CREDITO'";
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setDouble(1, tarjeta.getSaldo());
            ps.setString(2, tarjeta.getEstado().name());
            ps.setDouble(3, tarjeta.getCupo());
            ps.setDouble(4, tarjeta.getDeuda());
            ps.setInt(5, tarjeta.getNumeroCuotas());
            ps.setString(6, numeroCuenta);
            ps.executeUpdate();
            return tarjeta;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar tarjeta de crédito: " + e.getMessage(), e);
        }
    }

    @Override
    public Optional<TarjetaCredito> findByNumeroCuenta(String numeroCuenta) {
        String sql = "SELECT c.*, cl.nombre_completo FROM cuenta c JOIN cliente cl ON c.cliente_id = cl.id WHERE c.numero_cuenta = ? AND c.tipo = 'TARJETA_CREDITO'";
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setString(1, numeroCuenta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return Optional.of(rowMapper.mapRow(rs));
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar tarjeta de crédito: " + e.getMessage(), e);
        }
    }

    @Override
    public List<TarjetaCredito> findAll() {
        String sql = "SELECT c.*, cl.nombre_completo FROM cuenta c JOIN cliente cl ON c.cliente_id = cl.id WHERE c.tipo = 'TARJETA_CREDITO'";
        List<TarjetaCredito> lista = new ArrayList<>();
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) lista.add(rowMapper.mapRow(rs));
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar tarjetas de crédito: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteByNumeroCuenta(String numeroCuenta) {
        String sql = "DELETE FROM cuenta WHERE numero_cuenta = ? AND tipo = 'TARJETA_CREDITO'";
        try (PreparedStatement ps = getConn().prepareStatement(sql)) {
            ps.setString(1, numeroCuenta);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar tarjeta de crédito: " + e.getMessage(), e);
        }
    }
}