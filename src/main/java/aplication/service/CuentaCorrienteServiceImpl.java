package aplication.service;

import aplication.domain.CuentaCorriente;
import aplication.domain.enums.EstadoCuenta;
<<<<<<< HEAD
import aplication.exception.RecursoNoEncontradoException;
import aplication.exception.ReglaDeNegocioException;
import aplication.factory.CuentaFactory;
import aplication.service.outputs.CuentaCorrienteService;
import aplication.service.ports.CuentaCorrienteRepositoryPort;
import aplication.session.ClienteSession;
=======
import aplication.service.outputs.CuentaCorrienteService;
import aplication.service.ports.CuentaCorrienteRepositoryPort;
import java.time.LocalDateTime;
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
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
<<<<<<< HEAD
            throw new ReglaDeNegocioException("Ya existe una cuenta corriente con numero: " + numeroCuenta);
        }
        int clienteId = ClienteSession.getInstance().getClienteActivo().getId();
        CuentaCorriente cuenta = CuentaFactory.crearCorriente(numeroCuenta, saldo,
                porcentajeSobregiro, limiteSobregiro, clienteId);
=======
            throw new IllegalArgumentException("Ya existe una cuenta corriente con numero: " + numeroCuenta);
        }
        CuentaCorriente cuenta = new CuentaCorriente(numeroCuenta, saldo, LocalDateTime.now(),
                EstadoCuenta.ACTIVA, porcentajeSobregiro, limiteSobregiro);
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
        return cuentaCorrienteRepositoryPort.save(cuenta);
    }

    @Override
    public CuentaCorriente actualizarCuentaCorriente(String numeroCuenta,
<<<<<<< HEAD
                                                     double porcentajeSobregiro,
                                                     double limiteSobregiro,
                                                     EstadoCuenta estado) {
        CuentaCorriente cuenta = cuentaCorrienteRepositoryPort.findByNumeroCuenta(numeroCuenta)
                .orElseThrow(() -> new RecursoNoEncontradoException("Cuenta corriente", numeroCuenta));
        cuenta.setPorcentajeSobregiro(porcentajeSobregiro);
        cuenta.setLimiteSobregiro(limiteSobregiro);
        cuenta.setEstado(estado);
=======
                                                     double porcentajeSobregiro, double limiteSobregiro) {
        CuentaCorriente cuenta = cuentaCorrienteRepositoryPort.findByNumeroCuenta(numeroCuenta)
                .orElseThrow(() -> new IllegalArgumentException("Cuenta " + numeroCuenta + " no encontrada."));
        cuenta.setPorcentajeSobregiro(porcentajeSobregiro);
        cuenta.setLimiteSobregiro(limiteSobregiro);
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
        return cuentaCorrienteRepositoryPort.update(numeroCuenta, cuenta);
    }

    @Override
    public Optional<CuentaCorriente> obtenerPorNumeroCuenta(String numeroCuenta) {
<<<<<<< HEAD
        int clienteId = ClienteSession.getInstance().getClienteActivo().getId();
        return cuentaCorrienteRepositoryPort.findByNumeroCuenta(numeroCuenta)
                .filter(c -> c.getClienteId() == clienteId);
=======
        return cuentaCorrienteRepositoryPort.findByNumeroCuenta(numeroCuenta);
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
    }

    @Override
    public List<CuentaCorriente> obtenerTodas() {
<<<<<<< HEAD
        int clienteId = ClienteSession.getInstance().getClienteActivo().getId();
        return cuentaCorrienteRepositoryPort.findAll()
                .stream()
                .filter(c -> c.getClienteId() == clienteId)
                .collect(java.util.stream.Collectors.toList());
=======
        return cuentaCorrienteRepositoryPort.findAll();
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
    }

    @Override
    public void eliminarCuentaCorriente(String numeroCuenta) {
<<<<<<< HEAD
        cuentaCorrienteRepositoryPort.findByNumeroCuenta(numeroCuenta)
                .orElseThrow(() -> new RecursoNoEncontradoException("Cuenta corriente", numeroCuenta));
        cuentaCorrienteRepositoryPort.deleteByNumeroCuenta(numeroCuenta);
    }
}
=======
        cuentaCorrienteRepositoryPort.deleteByNumeroCuenta(numeroCuenta);
    }
}
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
