package aplication.persistence.mapper;

import aplication.domain.CuentaCorriente;
import aplication.domain.enums.EstadoCuenta;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CuentaCorrienteRowMapper implements RowMapper<CuentaCorriente> {

    @Override
    public CuentaCorriente mapRow(ResultSet rs) throws SQLException {
        CuentaCorriente c = new CuentaCorriente(
                rs.getString("numero_cuenta"),
                rs.getDouble("saldo"),
                rs.getTimestamp("fecha_apertura").toLocalDateTime(),
                EstadoCuenta.valueOf(rs.getString("estado")),
                rs.getDouble("porcentaje_sobregiro"),
                rs.getDouble("limite_sobregiro")
        );
        c.setClienteId(rs.getInt("cliente_id"));
        return c;
    }
}