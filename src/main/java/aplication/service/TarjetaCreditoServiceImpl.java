package aplication.service;

import aplication.domain.TarjetaCredito;
import aplication.domain.enums.EstadoCuenta;
<<<<<<< HEAD
import aplication.exception.RecursoNoEncontradoException;
import aplication.exception.ReglaDeNegocioException;
import aplication.factory.CuentaFactory;
import aplication.service.outputs.TarjetaCreditoService;
import aplication.service.ports.TarjetaCreditoRepositoryPort;
import aplication.session.ClienteSession;
=======
import aplication.service.outputs.TarjetaCreditoService;
import aplication.service.ports.TarjetaCreditoRepositoryPort;
import java.time.LocalDateTime;
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
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
<<<<<<< HEAD
            throw new ReglaDeNegocioException("Ya existe una tarjeta de credito con numero: " + numeroCuenta);
        }
        int clienteId = ClienteSession.getInstance().getClienteActivo().getId();
        TarjetaCredito tarjeta = CuentaFactory.crearTarjetaCredito(numeroCuenta, cupo,
                numeroCuotas, clienteId);
=======
            throw new IllegalArgumentException("Ya existe una tarjeta de credito con numero: " + numeroCuenta);
        }
        TarjetaCredito tarjeta = new TarjetaCredito(numeroCuenta, 0, LocalDateTime.now(),
                EstadoCuenta.ACTIVA, cupo, 0, numeroCuotas);
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
        return tarjetaCreditoRepositoryPort.save(tarjeta);
    }

    @Override
<<<<<<< HEAD
    public TarjetaCredito actualizarTarjetaCredito(String numeroCuenta, double cupo, int numeroCuotas, EstadoCuenta estado) {
        TarjetaCredito tarjeta = tarjetaCreditoRepositoryPort.findByNumeroCuenta(numeroCuenta) .orElseThrow(() -> new RecursoNoEncontradoException("Tarjeta de credito", numeroCuenta));
        tarjeta.setCupo(cupo);
        tarjeta.setNumeroCuotas(numeroCuotas);
        tarjeta.setEstado(estado);
=======
    public TarjetaCredito actualizarTarjetaCredito(String numeroCuenta, double cupo, int numeroCuotas) {
        TarjetaCredito tarjeta = tarjetaCreditoRepositoryPort.findByNumeroCuenta(numeroCuenta)
                .orElseThrow(() -> new IllegalArgumentException("Tarjeta " + numeroCuenta + " no encontrada."));
        tarjeta.setCupo(cupo);
        tarjeta.setNumeroCuotas(numeroCuotas);
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
        return tarjetaCreditoRepositoryPort.update(numeroCuenta, tarjeta);
    }

    @Override
    public Optional<TarjetaCredito> obtenerPorNumeroCuenta(String numeroCuenta) {
<<<<<<< HEAD
        int clienteId = ClienteSession.getInstance().getClienteActivo().getId();
        return tarjetaCreditoRepositoryPort.findByNumeroCuenta(numeroCuenta)
                .filter(t -> t.getClienteId() == clienteId);
=======
        return tarjetaCreditoRepositoryPort.findByNumeroCuenta(numeroCuenta);
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
    }

    @Override
    public List<TarjetaCredito> obtenerTodas() {
<<<<<<< HEAD
        int clienteId = ClienteSession.getInstance().getClienteActivo().getId();
        return tarjetaCreditoRepositoryPort.findAll()
                .stream()
                .filter(t -> t.getClienteId() == clienteId)
                .collect(java.util.stream.Collectors.toList());
=======
        return tarjetaCreditoRepositoryPort.findAll();
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
    }

    @Override
    public void eliminarTarjetaCredito(String numeroCuenta) {
<<<<<<< HEAD
        tarjetaCreditoRepositoryPort.findByNumeroCuenta(numeroCuenta)
                .orElseThrow(() -> new RecursoNoEncontradoException("Tarjeta de credito", numeroCuenta));
        tarjetaCreditoRepositoryPort.deleteByNumeroCuenta(numeroCuenta);
    }
}
=======
        tarjetaCreditoRepositoryPort.deleteByNumeroCuenta(numeroCuenta);
    }
}
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
