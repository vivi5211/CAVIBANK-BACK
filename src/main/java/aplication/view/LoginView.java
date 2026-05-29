package aplication.view;

import aplication.domain.Cliente;
import aplication.exception.BankException;
import aplication.service.outputs.AuthService;
import aplication.util.FormValidationUtil;

public class LoginView {

    private final AuthService authService;

    public LoginView(AuthService authService) {
        this.authService = authService;
    }

    public boolean mostrarLogin() {

        System.out.println("╔═══════════════════════════════╗");
        System.out.println("║       Bienvenido a CaviBank   ║");
        System.out.println("║         Inicie sesión         ║");
        System.out.println("╚═══════════════════════════════╝");

        int intentosVista = 0;
        int maxIntentos = 3;

        while (intentosVista < maxIntentos) {

            String usuario   = FormValidationUtil.validateString("Usuario: ");
            String contrasena = FormValidationUtil.validateString("Contraseña: ");

            try {
                Cliente cliente = authService.login(usuario, contrasena);
                System.out.println("\n✔ Bienvenido, " + cliente.getNombreCompleto() + "!");
                return true;

            } catch (BankException e) {
                intentosVista++;
                System.out.println("✘ " + e.getMessage());

                if (intentosVista < maxIntentos) {
                    System.out.println("  Intentos restantes: " + (maxIntentos - intentosVista));
                }
            }
        }

        System.out.println("\nDemasiados intentos fallidos. La aplicación se cerrará.");
        return false;
    }

    public void mostrarLogout() {
        authService.logout();
    }
}