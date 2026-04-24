package aplication.repository;

import aplication.domain.CuentaAhorros;
import aplication.domain.enums.EstadoCuenta;
import aplication.service.ports.CuentaAhorrosRepositoryPort;
import java.time.LocalDateTime;
import java.util.*;

public class CuentaAhorrosRepository implements CuentaAhorrosRepositoryPort {

    private final List<CuentaAhorros> cuentas = new ArrayList<>(Arrays.asList(
            new CuentaAhorros("AH-001", 5000000, LocalDateTime.now(), EstadoCuenta.ACTIVA, 3.5),
            new CuentaAhorros("AH-002", 1200000, LocalDateTime.now(), EstadoCuenta.ACTIVA, 3.5)
    ));

    @Override
    public CuentaAhorros save(CuentaAhorros cuenta) {
        cuentas.add(cuenta);
        return cuenta;
    }

    @Override
    public CuentaAhorros update(String numeroCuenta, CuentaAhorros cuenta) {
        for (int i = 0; i < cuentas.size(); i++) {
            if (cuentas.get(i).getNumeroCuenta().equals(numeroCuenta)) {
                cuentas.set(i, cuenta);
                return cuenta;
            }
        }
        throw new IllegalArgumentException("Cuenta de ahorros " + numeroCuenta + " no encontrada.");
    }

    @Override
    public Optional<CuentaAhorros> findByNumeroCuenta(String numeroCuenta) {
        for (CuentaAhorros c : cuentas)
            if (c.getNumeroCuenta().equals(numeroCuenta)) return Optional.of(c);
        return Optional.empty();
    }

    @Override
    public List<CuentaAhorros> findAll() { return cuentas; }

    @Override
    public void deleteByNumeroCuenta(String numeroCuenta) {
        boolean removed = cuentas.removeIf(c -> c.getNumeroCuenta().equals(numeroCuenta));
        System.out.println(removed ? "Cuenta eliminada." : "Cuenta no encontrada.");
    }
}
