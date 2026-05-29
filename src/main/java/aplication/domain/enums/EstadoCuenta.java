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
<<<<<<< HEAD

    public static EstadoCuenta fromString(String valor) {
        for (EstadoCuenta e : values()) {
            if (e.name().equalsIgnoreCase(valor) || e.descripcion.equalsIgnoreCase(valor)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Estado de cuenta no válido: " + valor);
    }
=======
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
}