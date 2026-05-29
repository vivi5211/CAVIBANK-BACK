package aplication.service.outputs;

import aplication.domain.CuentaAhorros;
<<<<<<< HEAD
import aplication.domain.enums.EstadoCuenta;

=======
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
import java.util.List;
import java.util.Optional;

public interface CuentaAhorrosService {
    CuentaAhorros crearCuentaAhorros(String numeroCuenta, double saldo, double tasaInteres);
<<<<<<< HEAD
    CuentaAhorros actualizarCuentaAhorros(String numeroCuenta, double tasaInteres, EstadoCuenta estado);
=======
    CuentaAhorros actualizarCuentaAhorros(String numeroCuenta, double tasaInteres);
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
    Optional<CuentaAhorros> obtenerPorNumeroCuenta(String numeroCuenta);
    List<CuentaAhorros> obtenerTodas();
    void eliminarCuentaAhorros(String numeroCuenta);
}
