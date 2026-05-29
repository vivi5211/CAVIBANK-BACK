package aplication.persistence.mapper;

import aplication.domain.CuentaAhorros;
import aplication.domain.enums.EstadoCuenta;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CuentaAhorrosRowMapper implements RowMapper<CuentaAhorros> {

    @Override
    public CuentaAhorros mapRow(ResultSet rs) throws SQLException {
        CuentaAhorros c = new CuentaAhorros(
                rs.getString("numero_cuenta"),
                rs.getDouble("saldo"),
                rs.getTimestamp("fecha_apertura").toLocalDateTime(),
                EstadoCuenta.valueOf(rs.getString("estado")),
                rs.getDouble("tasa_interes")
        );
        c.setClienteId(rs.getInt("cliente_id"));
        return c;
    }
}