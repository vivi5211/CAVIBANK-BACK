package aplication.view;

import aplication.domain.CuentaAhorros;
import aplication.service.outputs.CuentaAhorrosService;
import aplication.util.FormValidationUtil;
import java.util.List;

public class CuentaAhorrosView {

    private final CuentaAhorrosService cuentaAhorrosService;

    public CuentaAhorrosView(CuentaAhorrosService cuentaAhorrosService) {
        this.cuentaAhorrosService = cuentaAhorrosService;
    }

    public void crearCuentaAhorros() {
        System.out.println("--- Crear Cuenta de Ahorros ---");
        try {
            String numeroCuenta = FormValidationUtil.validateString("Ingrese el numero de cuenta");
            double saldo = FormValidationUtil.validateDouble("Ingrese el saldo inicial");
            double tasaInteres = FormValidationUtil.validateDouble("Ingrese la tasa de interes (%)");
            CuentaAhorros creada = cuentaAhorrosService.crearCuentaAhorros(numeroCuenta, saldo, tasaInteres);
            System.out.println("Cuenta de ahorros creada: " + creada);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void actualizarCuentaAhorros() {
        System.out.println("--- Actualizar Cuenta de Ahorros ---");
        try {
            String numeroCuenta = FormValidationUtil.validateString("Ingrese el numero de cuenta");
            CuentaAhorros actual = cuentaAhorrosService.obtenerPorNumeroCuenta(numeroCuenta)
                    .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada."));
            System.out.println("Datos actuales: " + actual);
            double tasaInteres = FormValidationUtil.validateDouble("Nueva tasa de interes (%) (" + actual.getTasaInteres() + ")");
            CuentaAhorros actualizada = cuentaAhorrosService.actualizarCuentaAhorros(numeroCuenta, tasaInteres);
            System.out.println("Cuenta actualizada: " + actualizada);
        } catch (IllegalArgumentException e) {
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
