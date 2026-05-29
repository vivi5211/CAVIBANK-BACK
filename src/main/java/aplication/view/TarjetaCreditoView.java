package aplication.view;

import aplication.domain.TarjetaCredito;
<<<<<<< HEAD
import aplication.domain.enums.EstadoCuenta;
import aplication.exception.RecursoNoEncontradoException;
import aplication.selector.EstadoCuentaSelector;
import aplication.service.outputs.TarjetaCreditoService;
import aplication.util.FormValidationUtil;
import aplication.util.NumeroCuentaUtil;

=======
import aplication.service.outputs.TarjetaCreditoService;
import aplication.util.FormValidationUtil;
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
import java.util.List;

public class TarjetaCreditoView {

    private final TarjetaCreditoService tarjetaCreditoService;

    public TarjetaCreditoView(TarjetaCreditoService tarjetaCreditoService) {
        this.tarjetaCreditoService = tarjetaCreditoService;
    }

    public void crearTarjetaCredito() {
        System.out.println("--- Crear Tarjeta de Credito ---");
        try {
<<<<<<< HEAD
            double cupo      = FormValidationUtil.validateDouble("Ingrese el cupo: ");
            int numeroCuotas = FormValidationUtil.validateInt("Ingrese el numero de cuotas por defecto: ");
            TarjetaCredito creada = tarjetaCreditoService.crearTarjetaCredito(
                    NumeroCuentaUtil.generar("TC"), cupo, numeroCuotas);
            System.out.println("Tarjeta creada exitosamente.");
            System.out.println("  Número: " + creada.getNumeroCuenta());
            System.out.println("  Cupo:   $" + creada.getCupo());
=======
            String numeroCuenta = FormValidationUtil.validateString("Ingrese el numero de tarjeta");
            double cupo = FormValidationUtil.validateDouble("Ingrese el cupo");
            int numeroCuotas = FormValidationUtil.validateInt("Ingrese el numero de cuotas por defecto");
            TarjetaCredito creada = tarjetaCreditoService.crearTarjetaCredito(numeroCuenta, cupo, numeroCuotas);
            System.out.println("Tarjeta de credito creada: " + creada);
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void actualizarTarjetaCredito() {
<<<<<<< HEAD
        System.out.println("--- Actualizar Tarjeta de Crédito ---");
        try {
            String numeroCuenta = FormValidationUtil.validateString("Ingrese el número de tarjeta: ");

            tarjetaCreditoService.obtenerPorNumeroCuenta(numeroCuenta)
                    .orElseThrow(() -> new RecursoNoEncontradoException("Tarjeta de crédito", numeroCuenta));

            double cupo      = FormValidationUtil.validateDouble("Ingrese el nuevo cupo: ");
            int numeroCuotas = FormValidationUtil.validateInt("Ingrese el nuevo número de cuotas: ");
            EstadoCuenta estado = EstadoCuentaSelector.seleccionar();

            TarjetaCredito actualizada = tarjetaCreditoService.actualizarTarjetaCredito(
                    numeroCuenta, cupo, numeroCuotas, estado);
            System.out.println("Tarjeta actualizada: " + actualizada.getNumeroCuenta()
                    + " | Estado: " + actualizada.getEstado().getDescripcion());
        } catch (Exception e) {
=======
        System.out.println("--- Actualizar Tarjeta de Credito ---");
        try {
            String numeroCuenta = FormValidationUtil.validateString("Ingrese el numero de tarjeta");
            TarjetaCredito actual = tarjetaCreditoService.obtenerPorNumeroCuenta(numeroCuenta)
                    .orElseThrow(() -> new IllegalArgumentException("Tarjeta no encontrada."));
            System.out.println("Datos actuales: " + actual);
            double cupo = FormValidationUtil.validateDouble("Nuevo cupo (" + actual.getCupo() + ")");
            int numeroCuotas = FormValidationUtil.validateInt("Nuevo numero de cuotas (" + actual.getNumeroCuotas() + ")");
            TarjetaCredito actualizada = tarjetaCreditoService.actualizarTarjetaCredito(numeroCuenta, cupo, numeroCuotas);
            System.out.println("Tarjeta actualizada: " + actualizada);
        } catch (IllegalArgumentException e) {
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void obtenerPorNumeroCuenta() {
        System.out.println("--- Buscar Tarjeta de Credito ---");
        try {
            String numeroCuenta = FormValidationUtil.validateString("Ingrese el numero de tarjeta");
            TarjetaCredito tarjeta = tarjetaCreditoService.obtenerPorNumeroCuenta(numeroCuenta)
                    .orElseThrow(() -> new IllegalArgumentException("Tarjeta no encontrada."));
            System.out.println(tarjeta);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void obtenerTodas() {
        System.out.println("--- Todas las Tarjetas de Credito ---");
        List<TarjetaCredito> tarjetas = tarjetaCreditoService.obtenerTodas();
        if (tarjetas.isEmpty()) {
            System.out.println("No hay tarjetas de credito registradas.");
        } else {
            for (TarjetaCredito t : tarjetas) {
                System.out.println(t.getNumeroCuenta() + " | Cupo: $" + t.getCupo() +
                        " | Deuda: $" + t.getDeuda() + " | Cuotas: " + t.getNumeroCuotas() +
                        " | Estado: " + t.getEstado().getDescripcion());
            }
        }
    }

    public void eliminarTarjetaCredito() {
        System.out.println("--- Eliminar Tarjeta de Credito ---");
        try {
            String numeroCuenta = FormValidationUtil.validateString("Ingrese el numero de tarjeta a eliminar");
            tarjetaCreditoService.eliminarTarjetaCredito(numeroCuenta);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
