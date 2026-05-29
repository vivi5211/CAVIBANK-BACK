package aplication.service.outputs;

import aplication.domain.CuentaAhorros;
import aplication.domain.enums.EstadoCuenta;

import java.util.List;
import java.util.Optional;

public interface CuentaAhorrosService {
    CuentaAhorros crearCuentaAhorros(String numeroCuenta, double saldo, double tasaInteres);
    CuentaAhorros actualizarCuentaAhorros(String numeroCuenta, double tasaInteres, EstadoCuenta estado);
    Optional<CuentaAhorros> obtenerPorNumeroCuenta(String numeroCuenta);
    List<CuentaAhorros> obtenerTodas();
    void eliminarCuentaAhorros(String numeroCuenta);
}
