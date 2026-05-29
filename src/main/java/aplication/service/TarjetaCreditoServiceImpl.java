package aplication.service;

import aplication.domain.TarjetaCredito;
import aplication.domain.enums.EstadoCuenta;
import aplication.exception.RecursoNoEncontradoException;
import aplication.exception.ReglaDeNegocioException;
import aplication.factory.CuentaFactory;
import aplication.service.outputs.TarjetaCreditoService;
import aplication.service.ports.TarjetaCreditoRepositoryPort;
import aplication.session.ClienteSession;
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
            throw new ReglaDeNegocioException("Ya existe una tarjeta de credito con numero: " + numeroCuenta);
        }
        int clienteId = ClienteSession.getInstance().getClienteActivo().getId();
        TarjetaCredito tarjeta = CuentaFactory.crearTarjetaCredito(numeroCuenta, cupo,
                numeroCuotas, clienteId);
        return tarjetaCreditoRepositoryPort.save(tarjeta);
    }

    @Override
    public TarjetaCredito actualizarTarjetaCredito(String numeroCuenta, double cupo, int numeroCuotas, EstadoCuenta estado) {
        TarjetaCredito tarjeta = tarjetaCreditoRepositoryPort.findByNumeroCuenta(numeroCuenta) .orElseThrow(() -> new RecursoNoEncontradoException("Tarjeta de credito", numeroCuenta));
        tarjeta.setCupo(cupo);
        tarjeta.setNumeroCuotas(numeroCuotas);
        tarjeta.setEstado(estado);
        return tarjetaCreditoRepositoryPort.update(numeroCuenta, tarjeta);
    }

    @Override
    public Optional<TarjetaCredito> obtenerPorNumeroCuenta(String numeroCuenta) {
        int clienteId = ClienteSession.getInstance().getClienteActivo().getId();
        return tarjetaCreditoRepositoryPort.findByNumeroCuenta(numeroCuenta)
                .filter(t -> t.getClienteId() == clienteId);
    }

    @Override
    public List<TarjetaCredito> obtenerTodas() {
        int clienteId = ClienteSession.getInstance().getClienteActivo().getId();
        return tarjetaCreditoRepositoryPort.findAll()
                .stream()
                .filter(t -> t.getClienteId() == clienteId)
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public void eliminarTarjetaCredito(String numeroCuenta) {
        tarjetaCreditoRepositoryPort.findByNumeroCuenta(numeroCuenta)
                .orElseThrow(() -> new RecursoNoEncontradoException("Tarjeta de credito", numeroCuenta));
        tarjetaCreditoRepositoryPort.deleteByNumeroCuenta(numeroCuenta);
    }
}