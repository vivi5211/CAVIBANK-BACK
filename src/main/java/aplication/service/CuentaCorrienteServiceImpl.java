package aplication.service;

import aplication.domain.CuentaCorriente;
import aplication.domain.enums.EstadoCuenta;
import aplication.exception.RecursoNoEncontradoException;
import aplication.exception.ReglaDeNegocioException;
import aplication.factory.CuentaFactory;
import aplication.service.outputs.CuentaCorrienteService;
import aplication.service.ports.CuentaCorrienteRepositoryPort;
import aplication.session.ClienteSession;
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
            throw new ReglaDeNegocioException("Ya existe una cuenta corriente con numero: " + numeroCuenta);
        }
        int clienteId = ClienteSession.getInstance().getClienteActivo().getId();
        CuentaCorriente cuenta = CuentaFactory.crearCorriente(numeroCuenta, saldo,
                porcentajeSobregiro, limiteSobregiro, clienteId);
        return cuentaCorrienteRepositoryPort.save(cuenta);
    }

    @Override
    public CuentaCorriente actualizarCuentaCorriente(String numeroCuenta,
                                                     double porcentajeSobregiro,
                                                     double limiteSobregiro,
                                                     EstadoCuenta estado) {
        CuentaCorriente cuenta = cuentaCorrienteRepositoryPort.findByNumeroCuenta(numeroCuenta)
                .orElseThrow(() -> new RecursoNoEncontradoException("Cuenta corriente", numeroCuenta));
        cuenta.setPorcentajeSobregiro(porcentajeSobregiro);
        cuenta.setLimiteSobregiro(limiteSobregiro);
        cuenta.setEstado(estado);
        return cuentaCorrienteRepositoryPort.update(numeroCuenta, cuenta);
    }

    @Override
    public Optional<CuentaCorriente> obtenerPorNumeroCuenta(String numeroCuenta) {
        int clienteId = ClienteSession.getInstance().getClienteActivo().getId();
        return cuentaCorrienteRepositoryPort.findByNumeroCuenta(numeroCuenta)
                .filter(c -> c.getClienteId() == clienteId);
    }

    @Override
    public List<CuentaCorriente> obtenerTodas() {
        int clienteId = ClienteSession.getInstance().getClienteActivo().getId();
        return cuentaCorrienteRepositoryPort.findAll()
                .stream()
                .filter(c -> c.getClienteId() == clienteId)
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public void eliminarCuentaCorriente(String numeroCuenta) {
        cuentaCorrienteRepositoryPort.findByNumeroCuenta(numeroCuenta)
                .orElseThrow(() -> new RecursoNoEncontradoException("Cuenta corriente", numeroCuenta));
        cuentaCorrienteRepositoryPort.deleteByNumeroCuenta(numeroCuenta);
    }
}