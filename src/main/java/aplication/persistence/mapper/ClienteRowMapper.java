package aplication.persistence.mapper;

import aplication.domain.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteRowMapper implements RowMapper<Cliente> {

    @Override
    public Cliente mapRow(ResultSet rs) throws SQLException {
        Cliente c = new Cliente(
                rs.getInt("id"),
                rs.getString("identificacion"),
                rs.getString("nombre_completo"),
                rs.getString("celular"),
                rs.getString("email"),
                rs.getString("usuario"),
                rs.getString("contrasena")
        );
        c.setIntentosFallidos(rs.getInt("intentos_fallidos"));
        c.setBloqueado(rs.getBoolean("bloqueado"));
        c.setCuentas(new ArrayList<>());
        return c;
    }
}