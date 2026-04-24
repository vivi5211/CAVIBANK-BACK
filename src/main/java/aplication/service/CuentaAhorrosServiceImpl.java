package aplication.service;

import aplication.domain.CuentaAhorros;
import aplication.domain.enums.EstadoCuenta;
import aplication.service.outputs.CuentaAhorrosService;
import aplication.service.ports.CuentaAhorrosRepositoryPort;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class CuentaAhorrosServiceImpl implements CuentaAhorrosService {

    private final CuentaAhorrosRepositoryPort cuentaAhorrosRepositoryPort;

    public CuentaAhorrosServiceImpl(CuentaAhorrosRepositoryPort cuentaAhorrosRepositoryPort) {
        this.cuentaAhorrosRepositoryPort = cuentaAhorrosRepositoryPort;
    }

    @Override
    public CuentaAhorros crearCuentaAhorros(String numeroCuenta, double saldo, double tasaInteres) {
        if (cuentaAhorrosRepositoryPort.findByNumeroCuenta(numeroCuenta).isPresent()) {
            throw new IllegalArgumentException("Ya existe una cuenta de ahorros con numero: " + numeroCuenta);
        }
        CuentaAhorros cuenta = new CuentaAhorros(numeroCuenta, saldo, LocalDateTime.now(),
                EstadoCuenta.ACTIVA, tasaInteres);
        return cuentaAhorrosRepositoryPort.save(cuenta);
    }

    @Override
    public CuentaAhorros actualizarCuentaAhorros(String numeroCuenta, double tasaInteres) {
        CuentaAhorros cuenta = cuentaAhorrosRepositoryPort.findByNumeroCuenta(numeroCuenta)
                .orElseThrow(() -> new IllegalArgumentException("Cuenta " + numeroCuenta + " no encontrada."));
        cuenta.setTasaInteres(tasaInteres);
        return cuentaAhorrosRepositoryPort.update(numeroCuenta, cuenta);
    }

    @Override
    public Optional<CuentaAhorros> obtenerPorNumeroCuenta(String numeroCuenta) {
        return cuentaAhorrosRepositoryPort.findByNumeroCuenta(numeroCuenta);
    }

    @Override
    public List<CuentaAhorros> obtenerTodas() {
        return cuentaAhorrosRepositoryPort.findAll();
    }

    @Override
    public void eliminarCuentaAhorros(String numeroCuenta) {
        cuentaAhorrosRepositoryPort.deleteByNumeroCuenta(numeroCuenta);
    }
}
