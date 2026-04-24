package aplication.view;

import aplication.domain.CuentaCorriente;
import aplication.service.outputs.CuentaCorrienteService;
import aplication.util.FormValidationUtil;
import java.util.List;

public class CuentaCorrienteView {

    private final CuentaCorrienteService cuentaCorrienteService;

    public CuentaCorrienteView(CuentaCorrienteService cuentaCorrienteService) {
        this.cuentaCorrienteService = cuentaCorrienteService;
    }

    public void crearCuentaCorriente() {
        System.out.println("--- Crear Cuenta Corriente ---");
        try {
            String numeroCuenta = FormValidationUtil.validateString("Ingrese el numero de cuenta");
            double saldo = FormValidationUtil.validateDouble("Ingrese el saldo inicial");
            double porcentajeSobregiro = FormValidationUtil.validateDouble("Ingrese el porcentaje de sobregiro (%)");
            double limiteSobregiro = FormValidationUtil.validateDouble("Ingrese el limite de sobregiro");
            CuentaCorriente creada = cuentaCorrienteService.crearCuentaCorriente(numeroCuenta, saldo, porcentajeSobregiro, limiteSobregiro);
            System.out.println("Cuenta corriente creada: " + creada);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void actualizarCuentaCorriente() {
        System.out.println("--- Actualizar Cuenta Corriente ---");
        try {
            String numeroCuenta = FormValidationUtil.validateString("Ingrese el numero de cuenta");
            CuentaCorriente actual = cuentaCorrienteService.obtenerPorNumeroCuenta(numeroCuenta)
                    .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada."));
            System.out.println("Datos actuales: " + actual);
            double porcentajeSobregiro = FormValidationUtil.validateDouble("Nuevo porcentaje de sobregiro (%) (" + actual.getPorcentajeSobregiro() + ")");
            double limiteSobregiro = FormValidationUtil.validateDouble("Nuevo limite de sobregiro (" + actual.getLimiteSobregiro() + ")");
            CuentaCorriente actualizada = cuentaCorrienteService.actualizarCuentaCorriente(numeroCuenta, porcentajeSobregiro, limiteSobregiro);
            System.out.println("Cuenta actualizada: " + actualizada);
        } catch (IllegalArgumentException e) {
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
