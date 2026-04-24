package aplication.repository;

import aplication.domain.CuentaCorriente;
import aplication.domain.enums.EstadoCuenta;
import aplication.service.ports.CuentaCorrienteRepositoryPort;
import java.time.LocalDateTime;
import java.util.*;

public class CuentaCorrienteRepository implements CuentaCorrienteRepositoryPort {

    private final List<CuentaCorriente> cuentas = new ArrayList<>(Arrays.asList(
            new CuentaCorriente("CC-001", 3000000, LocalDateTime.now(), EstadoCuenta.ACTIVA, 10.0, 300000),
            new CuentaCorriente("CC-002", 800000, LocalDateTime.now(), EstadoCuenta.ACTIVA, 10.0, 80000)
    ));

    @Override
    public CuentaCorriente save(CuentaCorriente cuenta) { cuentas.add(cuenta); return cuenta; }

    @Override
    public CuentaCorriente update(String numeroCuenta, CuentaCorriente cuenta) {
        for (int i = 0; i < cuentas.size(); i++) {
            if (cuentas.get(i).getNumeroCuenta().equals(numeroCuenta)) {
                cuentas.set(i, cuenta); return cuenta;
            }
        }
        throw new IllegalArgumentException("Cuenta no encontrada: " + numeroCuenta);
    }

    @Override
    public Optional<CuentaCorriente> findByNumeroCuenta(String numeroCuenta) {
        for (CuentaCorriente c : cuentas)
            if (c.getNumeroCuenta().equals(numeroCuenta)) return Optional.of(c);
        return Optional.empty();
    }

    @Override
    public List<CuentaCorriente> findAll() { return cuentas; }

    @Override
    public void deleteByNumeroCuenta(String numeroCuenta) {
        boolean removed = cuentas.removeIf(c -> c.getNumeroCuenta().equals(numeroCuenta));
        System.out.println(removed ? "Cuenta eliminada." : "Cuenta no encontrada.");
    }
}