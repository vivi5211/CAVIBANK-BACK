package aplication.userinterface;

import aplication.util.FormValidationUtil;
import aplication.view.ClienteView;
import aplication.view.CuentaAhorrosView;
import aplication.view.CuentaCorrienteView;
<<<<<<< HEAD
import aplication.view.LoginView;
=======
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
import aplication.view.TarjetaCreditoView;

public class MenuApp {

<<<<<<< HEAD
    private final LoginView loginView;
=======
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
    private final ClienteView clienteView;
    private final CuentaAhorrosView cuentaAhorrosView;
    private final CuentaCorrienteView cuentaCorrienteView;
    private final TarjetaCreditoView tarjetaCreditoView;

<<<<<<< HEAD
    public MenuApp(LoginView loginView, ClienteView clienteView,
                   CuentaAhorrosView cuentaAhorrosView,
                   CuentaCorrienteView cuentaCorrienteView,
                   TarjetaCreditoView tarjetaCreditoView) {
        this.loginView = loginView;
=======
    public MenuApp(ClienteView clienteView, CuentaAhorrosView cuentaAhorrosView,
                   CuentaCorrienteView cuentaCorrienteView, TarjetaCreditoView tarjetaCreditoView) {
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
        this.clienteView = clienteView;
        this.cuentaAhorrosView = cuentaAhorrosView;
        this.cuentaCorrienteView = cuentaCorrienteView;
        this.tarjetaCreditoView = tarjetaCreditoView;
    }

    public void showMainMenu() {
<<<<<<< HEAD

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
=======
        System.out.println("╔═══════════════════════════════╗");
        System.out.println("║      Bienvenido a MiPlata     ║");
        System.out.println("╚═══════════════════════════════╝");

        boolean running = true;
        while (running) {
            System.out.println("\n1. Clientes");
            System.out.println("2. Cuentas de Ahorros");
            System.out.println("3. Cuentas Corrientes");
            System.out.println("4. Tarjetas de Credito");
            System.out.println("0. Salir");

            int option = FormValidationUtil.validateInt("Seleccione una opcion");
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
            switch (option) {
                case 1: showClienteMenu(); break;
                case 2: showCuentaAhorrosMenu(); break;
                case 3: showCuentaCorrienteMenu(); break;
                case 4: showTarjetaCreditoMenu(); break;
                case 0:
<<<<<<< HEAD
                    loginView.mostrarLogout();
                    running = false;
                    break;
                default: System.out.println("Opción no válida. Intente de nuevo.");
=======
                    System.out.println("Hasta pronto. Gracias por usar MiPlata!");
                    running = false;
                    break;
                default: System.out.println("Opcion no valida. Intente de nuevo.");
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
            }
        }
    }

    private void showClienteMenu() {
        boolean running = true;
        while (running) {
<<<<<<< HEAD
            System.out.println("\n--- Menú Clientes ---");
=======
            System.out.println("\n--- Menu Clientes ---");
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
            System.out.println("1. Crear Cliente");
            System.out.println("2. Actualizar Cliente");
            System.out.println("3. Eliminar Cliente");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Buscar Cliente por Id");
            System.out.println("6. Volver");
<<<<<<< HEAD
            int option = FormValidationUtil.validateInt("Opción: ");
=======
            int option = FormValidationUtil.validateInt("Opcion");
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
            switch (option) {
                case 1: clienteView.crearCliente(); break;
                case 2: clienteView.actualizarCliente(); break;
                case 3: clienteView.eliminarCliente(); break;
                case 4: clienteView.obtenerTodosLosClientes(); break;
                case 5: clienteView.obtenerClientePorId(); break;
                case 6: running = false; break;
<<<<<<< HEAD
                default: System.out.println("Opción no válida.");
=======
                default: System.out.println("Opcion no valida.");
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
            }
        }
    }

    private void showCuentaAhorrosMenu() {
        boolean running = true;
        while (running) {
<<<<<<< HEAD
            System.out.println("\n--- Menú Cuentas de Ahorros ---");
=======
            System.out.println("\n--- Menu Cuentas de Ahorros ---");
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
            System.out.println("1. Crear Cuenta de Ahorros");
            System.out.println("2. Actualizar Cuenta de Ahorros");
            System.out.println("3. Eliminar Cuenta de Ahorros");
            System.out.println("4. Listar Cuentas de Ahorros");
<<<<<<< HEAD
            System.out.println("5. Buscar por Número de Cuenta");
            System.out.println("6. Volver");
            int option = FormValidationUtil.validateInt("Opción: ");
=======
            System.out.println("5. Buscar por Numero de Cuenta");
            System.out.println("6. Volver");
            int option = FormValidationUtil.validateInt("Opcion");
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
            switch (option) {
                case 1: cuentaAhorrosView.crearCuentaAhorros(); break;
                case 2: cuentaAhorrosView.actualizarCuentaAhorros(); break;
                case 3: cuentaAhorrosView.eliminarCuentaAhorros(); break;
                case 4: cuentaAhorrosView.obtenerTodas(); break;
                case 5: cuentaAhorrosView.obtenerPorNumeroCuenta(); break;
                case 6: running = false; break;
<<<<<<< HEAD
                default: System.out.println("Opción no válida.");
=======
                default: System.out.println("Opcion no valida.");
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
            }
        }
    }

    private void showCuentaCorrienteMenu() {
        boolean running = true;
        while (running) {
<<<<<<< HEAD
            System.out.println("\n--- Menú Cuentas Corrientes ---");
=======
            System.out.println("\n--- Menu Cuentas Corrientes ---");
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
            System.out.println("1. Crear Cuenta Corriente");
            System.out.println("2. Actualizar Cuenta Corriente");
            System.out.println("3. Eliminar Cuenta Corriente");
            System.out.println("4. Listar Cuentas Corrientes");
<<<<<<< HEAD
            System.out.println("5. Buscar por Número de Cuenta");
            System.out.println("6. Volver");
            int option = FormValidationUtil.validateInt("Opción: ");
=======
            System.out.println("5. Buscar por Numero de Cuenta");
            System.out.println("6. Volver");
            int option = FormValidationUtil.validateInt("Opcion");
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
            switch (option) {
                case 1: cuentaCorrienteView.crearCuentaCorriente(); break;
                case 2: cuentaCorrienteView.actualizarCuentaCorriente(); break;
                case 3: cuentaCorrienteView.eliminarCuentaCorriente(); break;
                case 4: cuentaCorrienteView.obtenerTodas(); break;
                case 5: cuentaCorrienteView.obtenerPorNumeroCuenta(); break;
                case 6: running = false; break;
<<<<<<< HEAD
                default: System.out.println("Opción no válida.");
=======
                default: System.out.println("Opcion no valida.");
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
            }
        }
    }

    private void showTarjetaCreditoMenu() {
        boolean running = true;
        while (running) {
<<<<<<< HEAD
            System.out.println("\n--- Menú Tarjetas de Crédito ---");
            System.out.println("1. Crear Tarjeta de Crédito");
            System.out.println("2. Actualizar Tarjeta de Crédito");
            System.out.println("3. Eliminar Tarjeta de Crédito");
            System.out.println("4. Listar Tarjetas de Crédito");
            System.out.println("5. Buscar por Número de Tarjeta");
            System.out.println("6. Volver");
            int option = FormValidationUtil.validateInt("Opción: ");
=======
            System.out.println("\n--- Menu Tarjetas de Credito ---");
            System.out.println("1. Crear Tarjeta de Credito");
            System.out.println("2. Actualizar Tarjeta de Credito");
            System.out.println("3. Eliminar Tarjeta de Credito");
            System.out.println("4. Listar Tarjetas de Credito");
            System.out.println("5. Buscar por Numero de Tarjeta");
            System.out.println("6. Volver");
            int option = FormValidationUtil.validateInt("Opcion");
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
            switch (option) {
                case 1: tarjetaCreditoView.crearTarjetaCredito(); break;
                case 2: tarjetaCreditoView.actualizarTarjetaCredito(); break;
                case 3: tarjetaCreditoView.eliminarTarjetaCredito(); break;
                case 4: tarjetaCreditoView.obtenerTodas(); break;
                case 5: tarjetaCreditoView.obtenerPorNumeroCuenta(); break;
                case 6: running = false; break;
<<<<<<< HEAD
                default: System.out.println("Opción no válida.");
            }
        }
    }
}
=======
                default: System.out.println("Opcion no valida.");
            }
        }
    }
}
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
