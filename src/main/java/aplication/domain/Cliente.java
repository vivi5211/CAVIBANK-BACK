package aplication.domain;

import aplication.domain.interfaces.IAutenticable;
import java.util.ArrayList;
import java.util.List;

public class Cliente implements IAutenticable {

    private int id;
    private String identificacion;
    private String nombreCompleto;
    private String celular;
<<<<<<< HEAD
    private String email;
=======
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
    private String usuario;
    private String contrasena;
    private int intentosFallidos;
    private boolean bloqueado;
    private List<Cuenta> cuentas;

<<<<<<< HEAD



    public Cliente() {}

    public Cliente(int id, String identificacion, String nombreCompleto, String celular,
                   String email, String usuario, String contrasena) {
=======
    public Cliente() {}

    public Cliente(int id, String identificacion, String nombreCompleto, String celular,
                   String usuario, String contrasena) {
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
        this.id = id;
        this.identificacion = identificacion;
        this.nombreCompleto = nombreCompleto;
        this.celular = celular;
<<<<<<< HEAD
        this.email = email;
=======
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.intentosFallidos = 0;
        this.bloqueado = false;
        this.cuentas = new ArrayList<>();
    }

    @Override
    public boolean autenticar(String usuario, String contrasena) {
        if (bloqueado) return false;
        return this.usuario.equals(usuario) && this.contrasena.equals(contrasena);
    }

    @Override
    public void cerrarSesion() {
        System.out.println("Sesión cerrada para: " + nombreCompleto);
    }

    @Override
    public void cambiarContrasena(String old, String nueva) {
        if (this.contrasena.equals(old)) {
            this.contrasena = nueva;
            System.out.println("Contraseña actualizada correctamente.");
        } else {
            throw new IllegalArgumentException("La contraseña actual no es correcta.");
        }
    }

    public void incrementarIntentos() {
        intentosFallidos++;
        if (intentosFallidos >= 3) bloqueado = true;
    }

    public void resetearIntentos() {
        intentosFallidos = 0;
        bloqueado = false;
    }

    // Getters y Setters
<<<<<<< HEAD

    public void setIntentosFallidos(int intentosFallidos) {
        this.intentosFallidos = intentosFallidos;
    }
=======
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getIdentificacion() { return identificacion; }
    public void setIdentificacion(String identificacion) { this.identificacion = identificacion; }
    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }
    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
    public int getIntentosFallidos() { return intentosFallidos; }
    public boolean isBloqueado() { return bloqueado; }
    public void setBloqueado(boolean bloqueado) { this.bloqueado = bloqueado; }
    public List<Cuenta> getCuentas() { return cuentas; }
    public void setCuentas(List<Cuenta> cuentas) { this.cuentas = cuentas; }
<<<<<<< HEAD
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

=======
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460

    @Override
    public String toString() {
        return "Cliente{id=" + id + ", identificacion='" + identificacion +
<<<<<<< HEAD
                "', nombre='" + nombreCompleto + "', email='" + email +
                "', usuario='" + usuario + "', bloqueado=" + bloqueado + "}";
=======
                "', nombre='" + nombreCompleto + "', usuario='" + usuario +
                "', bloqueado=" + bloqueado + "}";
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
    }
}