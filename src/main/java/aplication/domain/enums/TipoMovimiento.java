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
}