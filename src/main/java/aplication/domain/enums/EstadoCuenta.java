package aplication.domain.enums;

public enum EstadoCuenta {
    ACTIVA("Cuenta Activa"),
    INACTIVA("Cuenta Inactiva"),
    BLOQUEADA("Cuenta Bloqueada"),
    CERRADA("Cuenta Cerrada");

    private final String descripcion;

    EstadoCuenta(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}