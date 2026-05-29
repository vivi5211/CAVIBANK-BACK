package aplication.service.outputs;

import aplication.domain.CuentaCorriente;
import aplication.domain.enums.EstadoCuenta;

import java.util.List;
import java.util.Optional;

public interface CuentaCorrienteService {
    CuentaCorriente crearCuentaCorriente(String numeroCuenta, double saldo,
                                         double porcentajeSobregiro, double limiteSobregiro);
    CuentaCorriente actualizarCuentaCorriente(String numeroCuenta, double porcentajeSobregiro,
                                              double limiteSobregiro, EstadoCuenta estado);
    Optional<CuentaCorriente> obtenerPorNumeroCuenta(String numeroCuenta);
    List<CuentaCorriente> obtenerTodas();
    void eliminarCuentaCorriente(String numeroCuenta);
}
