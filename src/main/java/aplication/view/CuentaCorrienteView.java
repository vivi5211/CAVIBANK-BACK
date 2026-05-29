package aplication.view;

import aplication.domain.CuentaCorriente;
import aplication.domain.enums.EstadoCuenta;
import aplication.exception.RecursoNoEncontradoException;
import aplication.selector.EstadoCuentaSelector;
import aplication.service.outputs.CuentaCorrienteService;
import aplication.util.FormValidationUtil;
import aplication.util.NumeroCuentaUtil;

import java.util.List;

public class CuentaCorrienteView {

    private final CuentaCorrienteService cuentaCorrienteService;

    public CuentaCorrienteView(CuentaCorrienteService cuentaCorrienteService) {
        this.cuentaCorrienteService = cuentaCorrienteService;
    }

    public void crearCuentaCorriente() {
        System.out.println("--- Crear Cuenta Corriente ---");
        try {
            double saldo              = FormValidationUtil.validateDouble("Ingrese el saldo inicial: ");
            double porcentajeSobregiro = FormValidationUtil.validateDouble("Ingrese el porcentaje de sobregiro (%): ");
            double limiteSobregiro    = FormValidationUtil.validateDouble("Ingrese el limite de sobregiro: ");
            CuentaCorriente creada = cuentaCorrienteService.crearCuentaCorriente(
                    NumeroCuentaUtil.generar("CC"), saldo, porcentajeSobregiro, limiteSobregiro);
            System.out.println("Cuenta creada exitosamente.");
            System.out.println("  Número:    " + creada.getNumeroCuenta());
            System.out.println("  Saldo:     $" + creada.getSaldo());
            System.out.println("  Sobregiro: " + creada.getPorcentajeSobregiro() + "%");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void actualizarCuentaCorriente() {
        System.out.println("--- Actualizar Cuenta Corriente ---");
        try {
            String numeroCuenta = FormValidationUtil.validateString("Ingrese el número de cuenta: ");

            cuentaCorrienteService.obtenerPorNumeroCuenta(numeroCuenta)
                    .orElseThrow(() -> new RecursoNoEncontradoException("Cuenta corriente", numeroCuenta));

            double porcentajeSobregiro = FormValidationUtil.validateDouble("Ingrese el nuevo porcentaje de sobregiro (%): ");
            double limiteSobregiro     = FormValidationUtil.validateDouble("Ingrese el nuevo límite de sobregiro: ");
            EstadoCuenta estado        = EstadoCuentaSelector.seleccionar();

            CuentaCorriente actualizada = cuentaCorrienteService.actualizarCuentaCorriente(
                    numeroCuenta, porcentajeSobregiro, limiteSobregiro, estado);
            System.out.println("Cuenta actualizada: " + actualizada.getNumeroCuenta()
                    + " | Estado: " + actualizada.getEstado().getDescripcion());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void obtenerPorNumeroCuenta() {
        System.out.println("--- Buscar Cuenta Corriente ---");
        try {
            String numeroCuenta = FormValidationUtil.validateString("Ingrese el numero de cuenta");
            CuentaCorriente cuenta = cuentaCorrienteService.obtenerPorNumeroCuenta(numeroCuenta)
                    .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada."));
            System.out.println(cuenta);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void obtenerTodas() {
        System.out.println("--- Todas las Cuentas Corrientes ---");
        List<CuentaCorriente> cuentas = cuentaCorrienteService.obtenerTodas();
        if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas corrientes registradas.");
        } else {
            for (CuentaCorriente c : cuentas) {
                System.out.println(c.getNumeroCuenta() + " | Saldo: $" + c.getSaldo() +
                        " | Sobregiro: " + c.getPorcentajeSobregiro() + "% | Limite: $" + c.getLimiteSobregiro() +
                        " | Estado: " + c.getEstado().getDescripcion());
            }
        }
    }

    public void eliminarCuentaCorriente() {
        System.out.println("--- Eliminar Cuenta Corriente ---");
        try {
            String numeroCuenta = FormValidationUtil.validateString("Ingrese el numero de cuenta a eliminar");
            cuentaCorrienteService.eliminarCuentaCorriente(numeroCuenta);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
