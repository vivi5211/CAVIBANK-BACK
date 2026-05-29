package aplication.domain.enums;

public enum TipoMovimiento {
    CONSIGNACION("Consignación"),
    RETIRO("Retiro"),
    TRANSFERENCIA_OUT("Transferencia Saliente"),
    TRANSFERENCIA_IN("Transferencia Entrante"),
    COMPRA_TC("Compra con Tarjeta"),
    PAGO_TC("Pago Tarjeta de Crédito");

    private final String descripcion;

    TipoMovimiento(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
<<<<<<< HEAD

    public static TipoMovimiento fromString(String valor) {
        for (TipoMovimiento t : values()) {
            if (t.name().equalsIgnoreCase(valor) || t.descripcion.equalsIgnoreCase(valor)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Tipo de movimiento no válido: " + valor);
    }
=======
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
}