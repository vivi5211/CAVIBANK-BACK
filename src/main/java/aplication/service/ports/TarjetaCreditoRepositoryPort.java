package aplication.service.ports;

import aplication.domain.TarjetaCredito;
import java.util.List;
import java.util.Optional;

public interface TarjetaCreditoRepositoryPort {
    TarjetaCredito save(TarjetaCredito tarjeta);
    TarjetaCredito update(String numeroCuenta, TarjetaCredito tarjeta);
    Optional<TarjetaCredito> findByNumeroCuenta(String numeroCuenta);
    List<TarjetaCredito> findAll();
    void deleteByNumeroCuenta(String numeroCuenta);
}