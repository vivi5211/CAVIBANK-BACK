package aplication.util;

import aplication.configuration.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NumeroCuentaUtil {

    private NumeroCuentaUtil() {}

    public static String generar(String prefijo) {
        String sql = "SELECT COUNT(*) FROM cuenta WHERE numero_cuenta LIKE ?";
        try (PreparedStatement ps = DatabaseConnection.getInstance().getConnection()
                .prepareStatement(sql)) {
            ps.setString(1, prefijo + "-%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int siguiente = rs.getInt(1) + 1;
                return prefijo + "-" + String.format("%03d", siguiente);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al generar número de cuenta: " + e.getMessage(), e);
        }
        return prefijo + "-001";
    }
}