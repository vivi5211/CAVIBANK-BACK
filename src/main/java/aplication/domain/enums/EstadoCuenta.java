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

    public static EstadoCuenta fromString(String valor) {
        for (EstadoCuenta e : values()) {
            if (e.name().equalsIgnoreCase(valor) || e.descripcion.equalsIgnoreCase(valor)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Estado de cuenta no válido: " + valor);
    }
}