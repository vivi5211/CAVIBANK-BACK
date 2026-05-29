package aplication.view;

import aplication.domain.CuentaAhorros;
<<<<<<< HEAD
import aplication.domain.enums.EstadoCuenta;
import aplication.exception.RecursoNoEncontradoException;
import aplication.selector.EstadoCuentaSelector;
import aplication.service.outputs.CuentaAhorrosService;
import aplication.util.FormValidationUtil;
import aplication.util.NumeroCuentaUtil;

=======
import aplication.service.outputs.CuentaAhorrosService;
import aplication.util.FormValidationUtil;
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
import java.util.List;

public class CuentaAhorrosView {

    private final CuentaAhorrosService cuentaAhorrosService;

    public CuentaAhorrosView(CuentaAhorrosService cuentaAhorrosService) {
        this.cuentaAhorrosService = cuentaAhorrosService;
    }

    public void crearCuentaAhorros() {
        System.out.println("--- Crear Cuenta de Ahorros ---");
        try {
<<<<<<< HEAD
            double saldo       = FormValidationUtil.validateDouble("Ingrese el saldo inicial: ");
            double tasaInteres = FormValidationUtil.validateDouble("Ingrese la tasa de interes (%): ");
            CuentaAhorros creada = cuentaAhorrosService.crearCuentaAhorros(
                    NumeroCuentaUtil.generar("AH"), saldo, tasaInteres);
            System.out.println("Cuenta creada exitosamente.");
            System.out.println("  Número: " + creada.getNumeroCuenta());
            System.out.println("  Saldo:  $" + creada.getSaldo());
            System.out.println("  Tasa:   " + creada.getTasaInteres() + "%");
=======
            String numeroCuenta = FormValidationUtil.validateString("Ingrese el numero de cuenta");
            double saldo = FormValidationUtil.validateDouble("Ingrese el saldo inicial");
            double tasaInteres = FormValidationUtil.validateDouble("Ingrese la tasa de interes (%)");
            CuentaAhorros creada = cuentaAhorrosService.crearCuentaAhorros(numeroCuenta, saldo, tasaInteres);
            System.out.println("Cuenta de ahorros creada: " + creada);
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void actualizarCuentaAhorros() {
        System.out.println("--- Actualizar Cuenta de Ahorros ---");
        try {
<<<<<<< HEAD
            String numeroCuenta = FormValidationUtil.validateString("Ingrese el número de cuenta: ");

            cuentaAhorrosService.obtenerPorNumeroCuenta(numeroCuenta)
                    .orElseThrow(() -> new RecursoNoEncontradoException("Cuenta de ahorros", numeroCuenta));

            double tasaInteres  = FormValidationUtil.validateDouble("Ingrese la nueva tasa de interés (%): ");
            EstadoCuenta estado = EstadoCuentaSelector.seleccionar();

            CuentaAhorros actualizada = cuentaAhorrosService.actualizarCuentaAhorros(
                    numeroCuenta, tasaInteres, estado);
            System.out.println("Cuenta actualizada: " + actualizada.getNumeroCuenta()
                    + " | Estado: " + actualizada.getEstado().getDescripcion());
        } catch (Exception e) {
=======
            String numeroCuenta = FormValidationUtil.validateString("Ingrese el numero de cuenta");
            CuentaAhorros actual = cuentaAhorrosService.obtenerPorNumeroCuenta(numeroCuenta)
                    .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada."));
            System.out.println("Datos actuales: " + actual);
            double tasaInteres = FormValidationUtil.validateDouble("Nueva tasa de interes (%) (" + actual.getTasaInteres() + ")");
            CuentaAhorros actualizada = cuentaAhorrosService.actualizarCuentaAhorros(numeroCuenta, tasaInteres);
            System.out.println("Cuenta actualizada: " + actualizada);
        } catch (IllegalArgumentException e) {
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void obtenerPorNumeroCuenta() {
        System.out.println("--- Buscar Cuenta de Ahorros ---");
        try {
            String numeroCuenta = FormValidationUtil.validateString("Ingrese el numero de cuenta");
            CuentaAhorros cuenta = cuentaAhorrosService.obtenerPorNumeroCuenta(numeroCuenta)
                    .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada."));
            System.out.println(cuenta);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void obtenerTodas() {
        System.out.println("--- Todas las Cuentas de Ahorros ---");
        List<CuentaAhorros> cuentas = cuentaAhorrosService.obtenerTodas();
        if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas de ahorros registradas.");
        } else {
            for (CuentaAhorros c : cuentas) {
                System.out.println(c.getNumeroCuenta() + " | Saldo: $" + c.getSaldo() +
                        " | Tasa: " + c.getTasaInteres() + "% | Estado: " + c.getEstado().getDescripcion());
            }
        }
    }

    public void eliminarCuentaAhorros() {
        System.out.println("--- Eliminar Cuenta de Ahorros ---");
        try {
            String numeroCuenta = FormValidationUtil.validateString("Ingrese el numero de cuenta a eliminar");
            cuentaAhorrosService.eliminarCuentaAhorros(numeroCuenta);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
