package aplication.service.outputs;

import aplication.domain.TarjetaCredito;
import aplication.domain.enums.EstadoCuenta;

import java.util.List;
import java.util.Optional;

public interface TarjetaCreditoService {
    TarjetaCredito crearTarjetaCredito(String numeroCuenta, double cupo, int numeroCuotas);
    TarjetaCredito actualizarTarjetaCredito(String numeroCuenta, double cupo, int numeroCuotas, EstadoCuenta estado);
    Optional<TarjetaCredito> obtenerPorNumeroCuenta(String numeroCuenta);
    List<TarjetaCredito> obtenerTodas();
    void eliminarTarjetaCredito(String numeroCuenta);
}
