package aplication.util;

public class ValidationUtil {

<<<<<<< HEAD
    private ValidationUtil() {}

    public static String validateNotEmpty(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El campo '" + fieldName + "' no puede estar vacío.");
        }
        return value.trim();
    }

    public static String validateEmail(String email) {
        if (email == null || !email.matches("^[\\w._%+\\-]+@[\\w.\\-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException(
                    "El email '" + email + "' no tiene un formato válido. Ej: nombre@dominio.com");
        }
        return email.trim().toLowerCase();
    }

    public static String validatePassword(String password) {
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException(
                    "La contraseña debe tener mínimo 8 caracteres.");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new IllegalArgumentException(
                    "La contraseña debe contener al menos una letra mayúscula.");
        }
        if (!password.matches(".*[0-9].*")) {
            throw new IllegalArgumentException(
                    "La contraseña debe contener al menos un número.");
        }
        return password;
    }

    public static String validateCedula(String cedula) {
        if (cedula == null || !cedula.matches("^[0-9]{6,10}$")) {
            throw new IllegalArgumentException(
                    "La cédula '" + cedula + "' no es válida. Debe tener entre 6 y 10 dígitos.");
        }
        return cedula.trim();
    }

    public static String validateCelular(String celular) {
        if (celular == null || !celular.matches("^3[0-9]{9}$")) {
            throw new IllegalArgumentException(
                    "El celular '" + celular + "' no es válido. Debe empezar por 3 y tener 10 dígitos. Ej: 3001234567");
        }
        return celular.trim();
    }

    public static String validateUsuario(String usuario) {
        if (usuario == null || usuario.trim().length() < 4) {
            throw new IllegalArgumentException(
                    "El usuario debe tener mínimo 4 caracteres.");
        }
        if (!usuario.matches("^[a-zA-Z0-9_]+$")) {
            throw new IllegalArgumentException(
                    "El usuario solo puede contener letras, números y guion bajo.");
        }
        return usuario.trim().toLowerCase();
=======

    // Validación de texto

    public static String validateNotEmpty(String value, String fieldName) {
        try {
            if (value == null || value.trim().isEmpty()) {
                throw new IllegalArgumentException(
                        "El campo '" + fieldName + "' no puede estar vacío."
                );
            }
            return value.trim();
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validación: " + e.getMessage());
            throw e;
        }
    }


    // Validación de formato Email

    public static String validateEmail(String email) {
        try {
            if (email == null || !email.contains("@") || !email.contains(".")) {
                throw new IllegalArgumentException(
                        "El email '" + email + "' no tiene un formato válido."
                );
            }
            return email.trim();
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validación: " + e.getMessage());
            throw e;
        }
    }


    // Validación de contraseña

    public static String validatePassword(String password) {
        try {
            if (password == null || password.trim().length() < 6) {
                throw new IllegalArgumentException(
                        "La contraseña debe tener al menos 6 caracteres."
                );
            }
            return password.trim();
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validación: " + e.getMessage());
            throw e;
        }
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
    }
}