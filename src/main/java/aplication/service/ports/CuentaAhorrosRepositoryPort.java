package aplication.service.ports;

import aplication.domain.CuentaAhorros;
import java.util.List;
import java.util.Optional;

public interface CuentaAhorrosRepositoryPort {
    CuentaAhorros save(CuentaAhorros cuenta);
    CuentaAhorros update(String numeroCuenta, CuentaAhorros cuenta);
    Optional<CuentaAhorros> findByNumeroCuenta(String numeroCuenta);
    List<CuentaAhorros> findAll();
    void deleteByNumeroCuenta(String numeroCuenta);
}