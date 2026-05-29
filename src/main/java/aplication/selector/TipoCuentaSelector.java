package aplication.selector;

import aplication.util.FormValidationUtil;

public class TipoCuentaSelector {

    private TipoCuentaSelector() {}

    public static String seleccionar() {
        System.out.println("Seleccione el tipo de cuenta:");
        System.out.println("1. Cuenta de Ahorros");
        System.out.println("2. Cuenta Corriente");
        System.out.println("3. Tarjeta de Crédito");

        while (true) {
            int opcion = FormValidationUtil.validateInt("Opción: ");
            switch (opcion) {
                case 1: return "AHORROS";
                case 2: return "CORRIENTE";
                case 3: return "TARJETA_CREDITO";
                default: System.out.println("✘ Opción no válida. Intente de nuevo.");
            }
        }
    }
}