package aplication.selector;

import aplication.domain.enums.EstadoCuenta;
import aplication.util.FormValidationUtil;

public class EstadoCuentaSelector {

    private EstadoCuentaSelector() {}

    public static EstadoCuenta seleccionar() {
        System.out.println("Seleccione el estado:");
        System.out.println("1. Activa");
        System.out.println("2. Inactiva");
        System.out.println("3. Bloqueada");
        System.out.println("4. Cerrada");

        while (true) {
            int opcion = FormValidationUtil.validateInt("Opción: ");
            switch (opcion) {
                case 1: return EstadoCuenta.ACTIVA;
                case 2: return EstadoCuenta.INACTIVA;
                case 3: return EstadoCuenta.BLOQUEADA;
                case 4: return EstadoCuenta.CERRADA;
                default: System.out.println("✘ Opción no válida. Intente de nuevo.");
            }
        }
    }
}