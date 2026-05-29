package aplication.service.ports;

import aplication.domain.CuentaCorriente;
import java.util.List;
import java.util.Optional;

public interface CuentaCorrienteRepositoryPort {
    CuentaCorriente save(CuentaCorriente cuenta);
    CuentaCorriente update(String numeroCuenta, CuentaCorriente cuenta);
    Optional<CuentaCorriente> findByNumeroCuenta(String numeroCuenta);
    List<CuentaCorriente> findAll();
    void deleteByNumeroCuenta(String numeroCuenta);
}