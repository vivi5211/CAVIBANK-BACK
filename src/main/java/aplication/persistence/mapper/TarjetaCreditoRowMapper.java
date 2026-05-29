package aplication.persistence.mapper;

import aplication.domain.TarjetaCredito;
import aplication.domain.enums.EstadoCuenta;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TarjetaCreditoRowMapper implements RowMapper<TarjetaCredito> {

    @Override
    public TarjetaCredito mapRow(ResultSet rs) throws SQLException {
        TarjetaCredito t = new TarjetaCredito(
                rs.getString("numero_cuenta"),
                rs.getDouble("saldo"),
                rs.getTimestamp("fecha_apertura").toLocalDateTime(),
                EstadoCuenta.valueOf(rs.getString("estado")),
                rs.getDouble("cupo"),
                rs.getDouble("deuda"),
                rs.getInt("numero_cuotas")
        );
        t.setClienteId(rs.getInt("cliente_id"));
        return t;
    }
}