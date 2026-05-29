package aplication.selector;

import aplication.domain.enums.TipoMovimiento;
import aplication.util.FormValidationUtil;

public class TipoMovimientoSelector {

    private TipoMovimientoSelector() {}

    public static TipoMovimiento seleccionar() {
        System.out.println("Seleccione el tipo de movimiento:");
        System.out.println("1. Consignación");
        System.out.println("2. Retiro");
        System.out.println("3. Transferencia Saliente");
        System.out.println("4. Transferencia Entrante");
        System.out.println("5. Compra con Tarjeta");
        System.out.println("6. Pago Tarjeta de Crédito");

        while (true) {
            int opcion = FormValidationUtil.validateInt("Opción: ");
            switch (opcion) {
                case 1: return TipoMovimiento.CONSIGNACION;
                case 2: return TipoMovimiento.RETIRO;
                case 3: return TipoMovimiento.TRANSFERENCIA_OUT;
                case 4: return TipoMovimiento.TRANSFERENCIA_IN;
                case 5: return TipoMovimiento.COMPRA_TC;
                case 6: return TipoMovimiento.PAGO_TC;
                default: System.out.println("✘ Opción no válida. Intente de nuevo.");
            }
        }
    }
}