package aplication.service;

import aplication.domain.CuentaAhorros;
import aplication.domain.enums.EstadoCuenta;
<<<<<<< HEAD
import aplication.factory.CuentaFactory;
import aplication.service.outputs.CuentaAhorrosService;
import aplication.service.ports.CuentaAhorrosRepositoryPort;
import aplication.session.ClienteSession;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import aplication.exception.RecursoNoEncontradoException;
import aplication.exception.ReglaDeNegocioException;
=======
import aplication.service.outputs.CuentaAhorrosService;
import aplication.service.ports.CuentaAhorrosRepositoryPort;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460

public class CuentaAhorrosServiceImpl implements CuentaAhorrosService {

    private final CuentaAhorrosRepositoryPort cuentaAhorrosRepositoryPort;

    public CuentaAhorrosServiceImpl(CuentaAhorrosRepositoryPort cuentaAhorrosRepositoryPort) {
        this.cuentaAhorrosRepositoryPort = cuentaAhorrosRepositoryPort;
    }

    @Override
    public CuentaAhorros crearCuentaAhorros(String numeroCuenta, double saldo, double tasaInteres) {
        if (cuentaAhorrosRepositoryPort.findByNumeroCuenta(numeroCuenta).isPresent()) {
<<<<<<< HEAD
            throw new ReglaDeNegocioException("Ya existe una cuenta de ahorros con numero: " + numeroCuenta);
        }
        int clienteId = ClienteSession.getInstance().getClienteActivo().getId();
        CuentaAhorros cuenta = CuentaFactory.crearAhorros(numeroCuenta, saldo, tasaInteres, clienteId);
=======
            throw new IllegalArgumentException("Ya existe una cuenta de ahorros con numero: " + numeroCuenta);
        }
        CuentaAhorros cuenta = new CuentaAhorros(numeroCuenta, saldo, LocalDateTime.now(),
                EstadoCuenta.ACTIVA, tasaInteres);
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
        return cuentaAhorrosRepositoryPort.save(cuenta);
    }

    @Override
<<<<<<< HEAD
    public CuentaAhorros actualizarCuentaAhorros(String numeroCuenta, double tasaInteres, EstadoCuenta estado) {
        CuentaAhorros cuenta = cuentaAhorrosRepositoryPort.findByNumeroCuenta(numeroCuenta)
                .orElseThrow(() -> new RecursoNoEncontradoException("Cuenta de ahorros", numeroCuenta));
        cuenta.setTasaInteres(tasaInteres);
        cuenta.setEstado(estado);
=======
    public CuentaAhorros actualizarCuentaAhorros(String numeroCuenta, double tasaInteres) {
        CuentaAhorros cuenta = cuentaAhorrosRepositoryPort.findByNumeroCuenta(numeroCuenta)
                .orElseThrow(() -> new IllegalArgumentException("Cuenta " + numeroCuenta + " no encontrada."));
        cuenta.setTasaInteres(tasaInteres);
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
        return cuentaAhorrosRepositoryPort.update(numeroCuenta, cuenta);
    }

    @Override
    public Optional<CuentaAhorros> obtenerPorNumeroCuenta(String numeroCuenta) {
<<<<<<< HEAD
        int clienteId = ClienteSession.getInstance().getClienteActivo().getId();
        return cuentaAhorrosRepositoryPort.findByNumeroCuenta(numeroCuenta)
                .filter(c -> c.getClienteId() == clienteId);
=======
        return cuentaAhorrosRepositoryPort.findByNumeroCuenta(numeroCuenta);
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
    }

    @Override
    public List<CuentaAhorros> obtenerTodas() {
<<<<<<< HEAD
        int clienteId = ClienteSession.getInstance().getClienteActivo().getId();
        return cuentaAhorrosRepositoryPort.findAll()
                .stream()
                .filter(c -> c.getClienteId() == clienteId)
                .collect(java.util.stream.Collectors.toList());
=======
        return cuentaAhorrosRepositoryPort.findAll();
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
    }

    @Override
    public void eliminarCuentaAhorros(String numeroCuenta) {
        cuentaAhorrosRepositoryPort.deleteByNumeroCuenta(numeroCuenta);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
