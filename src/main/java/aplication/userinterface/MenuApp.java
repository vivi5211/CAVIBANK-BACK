package aplication.userinterface;

import aplication.util.FormValidationUtil;
import aplication.view.ClienteView;
import aplication.view.CuentaAhorrosView;
import aplication.view.CuentaCorrienteView;
import aplication.view.LoginView;
import aplication.view.TarjetaCreditoView;

public class MenuApp {

    private final LoginView loginView;
    private final ClienteView clienteView;
    private final CuentaAhorrosView cuentaAhorrosView;
    private final CuentaCorrienteView cuentaCorrienteView;
    private final TarjetaCreditoView tarjetaCreditoView;

    public MenuApp(LoginView loginView, ClienteView clienteView,
                   CuentaAhorrosView cuentaAhorrosView,
                   CuentaCorrienteView cuentaCorrienteView,
                   TarjetaCreditoView tarjetaCreditoView) {
        this.loginView = loginView;
        this.clienteView = clienteView;
        this.cuentaAhorrosView = cuentaAhorrosView;
        this.cuentaCorrienteView = cuentaCorrienteView;
        this.tarjetaCreditoView = tarjetaCreditoView;
    }

    public void showMainMenu() {

        boolean loginExitoso = loginView.mostrarLogin();
        if (!loginExitoso) {
            System.out.println("No se pudo iniciar sesión. Hasta pronto.");
            return;
        }

        boolean running = true;
        while (running) {
            System.out.println("\n╔═══════════════════════════════╗");
            System.out.println("║         Menú Principal        ║");
            System.out.println("╚═══════════════════════════════╝");
            System.out.println("1. Clientes");
            System.out.println("2. Cuentas de Ahorros");
            System.out.println("3. Cuentas Corrientes");
            System.out.println("4. Tarjetas de Crédito");
            System.out.println("0. Cerrar sesión y salir");

            int option = FormValidationUtil.validateInt("Seleccione una opción: ");
            switch (option) {
                case 1: showClienteMenu(); break;
                case 2: showCuentaAhorrosMenu(); break;
                case 3: showCuentaCorrienteMenu(); break;
                case 4: showTarjetaCreditoMenu(); break;
                case 0:
                    loginView.mostrarLogout();
                    running = false;
                    break;
                default: System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void showClienteMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Menú Clientes ---");
            System.out.println("1. Crear Cliente");
            System.out.println("2. Actualizar Cliente");
            System.out.println("3. Eliminar Cliente");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Buscar Cliente por Id");
            System.out.println("6. Volver");
            int option = FormValidationUtil.validateInt("Opción: ");
            switch (option) {
                case 1: clienteView.crearCliente(); break;
                case 2: clienteView.actualizarCliente(); break;
                case 3: clienteView.eliminarCliente(); break;
                case 4: clienteView.obtenerTodosLosClientes(); break;
                case 5: clienteView.obtenerClientePorId(); break;
                case 6: running = false; break;
                default: System.out.println("Opción no válida.");
            }
        }
    }

    private void showCuentaAhorrosMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Menú Cuentas de Ahorros ---");
            System.out.println("1. Crear Cuenta de Ahorros");
            System.out.println("2. Actualizar Cuenta de Ahorros");
            System.out.println("3. Eliminar Cuenta de Ahorros");
            System.out.println("4. Listar Cuentas de Ahorros");
            System.out.println("5. Buscar por Número de Cuenta");
            System.out.println("6. Volver");
            int option = FormValidationUtil.validateInt("Opción: ");
            switch (option) {
                case 1: cuentaAhorrosView.crearCuentaAhorros(); break;
                case 2: cuentaAhorrosView.actualizarCuentaAhorros(); break;
                case 3: cuentaAhorrosView.eliminarCuentaAhorros(); break;
                case 4: cuentaAhorrosView.obtenerTodas(); break;
                case 5: cuentaAhorrosView.obtenerPorNumeroCuenta(); break;
                case 6: running = false; break;
                default: System.out.println("Opción no válida.");
            }
        }
    }

    private void showCuentaCorrienteMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Menú Cuentas Corrientes ---");
            System.out.println("1. Crear Cuenta Corriente");
            System.out.println("2. Actualizar Cuenta Corriente");
            System.out.println("3. Eliminar Cuenta Corriente");
            System.out.println("4. Listar Cuentas Corrientes");
            System.out.println("5. Buscar por Número de Cuenta");
            System.out.println("6. Volver");
            int option = FormValidationUtil.validateInt("Opción: ");
            switch (option) {
                case 1: cuentaCorrienteView.crearCuentaCorriente(); break;
                case 2: cuentaCorrienteView.actualizarCuentaCorriente(); break;
                case 3: cuentaCorrienteView.eliminarCuentaCorriente(); break;
                case 4: cuentaCorrienteView.obtenerTodas(); break;
                case 5: cuentaCorrienteView.obtenerPorNumeroCuenta(); break;
                case 6: running = false; break;
                default: System.out.println("Opción no válida.");
            }
        }
    }

    private void showTarjetaCreditoMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Menú Tarjetas de Crédito ---");
            System.out.println("1. Crear Tarjeta de Crédito");
            System.out.println("2. Actualizar Tarjeta de Crédito");
            System.out.println("3. Eliminar Tarjeta de Crédito");
            System.out.println("4. Listar Tarjetas de Crédito");
            System.out.println("5. Buscar por Número de Tarjeta");
            System.out.println("6. Volver");
            int option = FormValidationUtil.validateInt("Opción: ");
            switch (option) {
                case 1: tarjetaCreditoView.crearTarjetaCredito(); break;
                case 2: tarjetaCreditoView.actualizarTarjetaCredito(); break;
                case 3: tarjetaCreditoView.eliminarTarjetaCredito(); break;
                case 4: tarjetaCreditoView.obtenerTodas(); break;
                case 5: tarjetaCreditoView.obtenerPorNumeroCuenta(); break;
                case 6: running = false; break;
                default: System.out.println("Opción no válida.");
            }
        }
    }
}