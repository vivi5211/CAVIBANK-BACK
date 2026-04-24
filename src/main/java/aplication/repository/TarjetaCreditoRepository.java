package aplication.repository;

import aplication.domain.TarjetaCredito;
import aplication.domain.enums.EstadoCuenta;
import aplication.service.ports.TarjetaCreditoRepositoryPort;
import java.time.LocalDateTime;
import java.util.*;

public class TarjetaCreditoRepository implements TarjetaCreditoRepositoryPort {

    private final List<TarjetaCredito> tarjetas = new ArrayList<>(Arrays.asList(
            new TarjetaCredito("TC-001", 0, LocalDateTime.now(), EstadoCuenta.ACTIVA, 10000000, 0, 1),
            new TarjetaCredito("TC-002", 0, LocalDateTime.now(), EstadoCuenta.ACTIVA, 5000000, 0, 1)
    ));

    @Override
    public TarjetaCredito save(TarjetaCredito tarjeta) {
        tarjetas.add(tarjeta);
        return tarjeta;
    }

    @Override
    public TarjetaCredito update(String numeroCuenta, TarjetaCredito tarjeta) {
        for (int i = 0; i < tarjetas.size(); i++) {
            if (tarjetas.get(i).getNumeroCuenta().equals(numeroCuenta)) {
                tarjetas.set(i, tarjeta);
                return tarjeta;
            }
        }
        throw new IllegalArgumentException("Tarjeta de credito " + numeroCuenta + " no encontrada.");
    }

    @Override
    public Optional<TarjetaCredito> findByNumeroCuenta(String numeroCuenta) {
        for (TarjetaCredito t : tarjetas)
            if (t.getNumeroCuenta().equals(numeroCuenta)) return Optional.of(t);
        return Optional.empty();
    }

    @Override
    public List<TarjetaCredito> findAll() { return tarjetas; }

    @Override
    public void deleteByNumeroCuenta(String numeroCuenta) {
        boolean removed = tarjetas.removeIf(t -> t.getNumeroCuenta().equals(numeroCuenta));
        System.out.println(removed ? "Tarjeta eliminada." : "Tarjeta no encontrada.");
    }
}
