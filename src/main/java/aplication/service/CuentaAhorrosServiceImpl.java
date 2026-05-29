package aplication.service;

import aplication.domain.CuentaAhorros;
import aplication.domain.enums.EstadoCuenta;
import aplication.factory.CuentaFactory;
import aplication.service.outputs.CuentaAhorrosService;
import aplication.service.ports.CuentaAhorrosRepositoryPort;
import aplication.session.ClienteSession;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import aplication.exception.RecursoNoEncontradoException;
import aplication.exception.ReglaDeNegocioException;

public class CuentaAhorrosServiceImpl implements CuentaAhorrosService {

    private final CuentaAhorrosRepositoryPort cuentaAhorrosRepositoryPort;

    public CuentaAhorrosServiceImpl(CuentaAhorrosRepositoryPort cuentaAhorrosRepositoryPort) {
        this.cuentaAhorrosRepositoryPort = cuentaAhorrosRepositoryPort;
    }

    @Override
    public CuentaAhorros crearCuentaAhorros(String numeroCuenta, double saldo, double tasaInteres) {
        if (cuentaAhorrosRepositoryPort.findByNumeroCuenta(numeroCuenta).isPresent()) {
            throw new ReglaDeNegocioException("Ya existe una cuenta de ahorros con numero: " + numeroCuenta);
        }
        int clienteId = ClienteSession.getInstance().getClienteActivo().getId();
        CuentaAhorros cuenta = CuentaFactory.crearAhorros(numeroCuenta, saldo, tasaInteres, clienteId);
        return cuentaAhorrosRepositoryPort.save(cuenta);
    }

    @Override
    public CuentaAhorros actualizarCuentaAhorros(String numeroCuenta, double tasaInteres, EstadoCuenta estado) {
        CuentaAhorros cuenta = cuentaAhorrosRepositoryPort.findByNumeroCuenta(numeroCuenta)
                .orElseThrow(() -> new RecursoNoEncontradoException("Cuenta de ahorros", numeroCuenta));
        cuenta.setTasaInteres(tasaInteres);
        cuenta.setEstado(estado);
        return cuentaAhorrosRepositoryPort.update(numeroCuenta, cuenta);
    }

    @Override
    public Optional<CuentaAhorros> obtenerPorNumeroCuenta(String numeroCuenta) {
        int clienteId = ClienteSession.getInstance().getClienteActivo().getId();
        return cuentaAhorrosRepositoryPort.findByNumeroCuenta(numeroCuenta)
                .filter(c -> c.getClienteId() == clienteId);
    }

    @Override
    public List<CuentaAhorros> obtenerTodas() {
        int clienteId = ClienteSession.getInstance().getClienteActivo().getId();
        return cuentaAhorrosRepositoryPort.findAll()
                .stream()
                .filter(c -> c.getClienteId() == clienteId)
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public void eliminarCuentaAhorros(String numeroCuenta) {
        cuentaAhorrosRepositoryPort.deleteByNumeroCuenta(numeroCuenta);
    }
}