package aplication.service;

import aplication.domain.CuentaCorriente;
import aplication.domain.enums.EstadoCuenta;
import aplication.service.outputs.CuentaCorrienteService;
import aplication.service.ports.CuentaCorrienteRepositoryPort;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class CuentaCorrienteServiceImpl implements CuentaCorrienteService {

    private final CuentaCorrienteRepositoryPort cuentaCorrienteRepositoryPort;

    public CuentaCorrienteServiceImpl(CuentaCorrienteRepositoryPort cuentaCorrienteRepositoryPort) {
        this.cuentaCorrienteRepositoryPort = cuentaCorrienteRepositoryPort;
    }

    @Override
    public CuentaCorriente crearCuentaCorriente(String numeroCuenta, double saldo,
                                                double porcentajeSobregiro, double limiteSobregiro) {
        if (cuentaCorrienteRepositoryPort.findByNumeroCuenta(numeroCuenta).isPresent()) {
            throw new IllegalArgumentException("Ya existe una cuenta corriente con numero: " + numeroCuenta);
        }
        CuentaCorriente cuenta = new CuentaCorriente(numeroCuenta, saldo, LocalDateTime.now(),
                EstadoCuenta.ACTIVA, porcentajeSobregiro, limiteSobregiro);
        return cuentaCorrienteRepositoryPort.save(cuenta);
    }

    @Override
    public CuentaCorriente actualizarCuentaCorriente(String numeroCuenta,
                                                     double porcentajeSobregiro, double limiteSobregiro) {
        CuentaCorriente cuenta = cuentaCorrienteRepositoryPort.findByNumeroCuenta(numeroCuenta)
                .orElseThrow(() -> new IllegalArgumentException("Cuenta " + numeroCuenta + " no encontrada."));
        cuenta.setPorcentajeSobregiro(porcentajeSobregiro);
        cuenta.setLimiteSobregiro(limiteSobregiro);
        return cuentaCorrienteRepositoryPort.update(numeroCuenta, cuenta);
    }

    @Override
    public Optional<CuentaCorriente> obtenerPorNumeroCuenta(String numeroCuenta) {
        return cuentaCorrienteRepositoryPort.findByNumeroCuenta(numeroCuenta);
    }

    @Override
    public List<CuentaCorriente> obtenerTodas() {
        return cuentaCorrienteRepositoryPort.findAll();
    }

    @Override
    public void eliminarCuentaCorriente(String numeroCuenta) {
        cuentaCorrienteRepositoryPort.deleteByNumeroCuenta(numeroCuenta);
    }
}
