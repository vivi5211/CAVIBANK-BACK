package aplication.service;

import aplication.domain.TarjetaCredito;
import aplication.domain.enums.EstadoCuenta;
import aplication.service.outputs.TarjetaCreditoService;
import aplication.service.ports.TarjetaCreditoRepositoryPort;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class TarjetaCreditoServiceImpl implements TarjetaCreditoService {

    private final TarjetaCreditoRepositoryPort tarjetaCreditoRepositoryPort;

    public TarjetaCreditoServiceImpl(TarjetaCreditoRepositoryPort tarjetaCreditoRepositoryPort) {
        this.tarjetaCreditoRepositoryPort = tarjetaCreditoRepositoryPort;
    }

    @Override
    public TarjetaCredito crearTarjetaCredito(String numeroCuenta, double cupo, int numeroCuotas) {
        if (tarjetaCreditoRepositoryPort.findByNumeroCuenta(numeroCuenta).isPresent()) {
            throw new IllegalArgumentException("Ya existe una tarjeta de credito con numero: " + numeroCuenta);
        }
        TarjetaCredito tarjeta = new TarjetaCredito(numeroCuenta, 0, LocalDateTime.now(),
                EstadoCuenta.ACTIVA, cupo, 0, numeroCuotas);
        return tarjetaCreditoRepositoryPort.save(tarjeta);
    }

    @Override
    public TarjetaCredito actualizarTarjetaCredito(String numeroCuenta, double cupo, int numeroCuotas) {
        TarjetaCredito tarjeta = tarjetaCreditoRepositoryPort.findByNumeroCuenta(numeroCuenta)
                .orElseThrow(() -> new IllegalArgumentException("Tarjeta " + numeroCuenta + " no encontrada."));
        tarjeta.setCupo(cupo);
        tarjeta.setNumeroCuotas(numeroCuotas);
        return tarjetaCreditoRepositoryPort.update(numeroCuenta, tarjeta);
    }

    @Override
    public Optional<TarjetaCredito> obtenerPorNumeroCuenta(String numeroCuenta) {
        return tarjetaCreditoRepositoryPort.findByNumeroCuenta(numeroCuenta);
    }

    @Override
    public List<TarjetaCredito> obtenerTodas() {
        return tarjetaCreditoRepositoryPort.findAll();
    }

    @Override
    public void eliminarTarjetaCredito(String numeroCuenta) {
        tarjetaCreditoRepositoryPort.deleteByNumeroCuenta(numeroCuenta);
    }
}
