package aplication.view;

import aplication.domain.Cliente;
import aplication.domain.Cuenta;
import aplication.service.outputs.ClienteService;
import aplication.util.FormValidationUtil;
import aplication.util.ValidationUtil;
import java.util.List;

public class ClienteView {

    private final ClienteService clienteService;

    public ClienteView(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void crearCliente() {
        System.out.println("--- Crear Cliente ---");
        try {
            String identificacion = pedirCedula();
            String nombreCompleto = pedirNombre();
            String celular        = pedirCelular();
            String email          = pedirEmail();
            String usuario        = pedirUsuario();
            String contrasena     = pedirContrasena();
            Cliente creado = clienteService.crearCliente(0, identificacion,
                    nombreCompleto, celular, email, usuario, contrasena);
            System.out.println("Cliente creado con id: " + creado.getId()
                    + " — " + creado.getNombreCompleto());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void actualizarCliente() {
        System.out.println("--- Actualizar Cliente ---");
        try {
            int id = FormValidationUtil.validateInt("Ingrese el id del cliente a actualizar: ");
            Cliente actual = clienteService.obtenerClientePorId(id)
                    .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado."));
            System.out.println("Datos actuales: " + actual);
            String identificacion = pedirCedula();
            String nombreCompleto = pedirNombre();
            String celular        = pedirCelular();
            String email          = pedirEmail();
            String usuario        = pedirUsuario();
            String contrasena     = pedirContrasena();
            Cliente actualizado = clienteService.actualizarCliente(id, identificacion,
                    nombreCompleto, celular, email, usuario, contrasena);
            System.out.println("Cliente actualizado: " + actualizado);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void obtenerClientePorId() {
        System.out.println("--- Buscar Cliente por Id ---");
        try {
            int id = FormValidationUtil.validateInt("Ingrese el id del cliente: ");
            Cliente cliente = clienteService.obtenerClientePorId(id)
                    .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado."));
            System.out.println("\n" + cliente);
            System.out.println("Cuentas asociadas: " + cliente.getCuentas().size());
            if (cliente.getCuentas().isEmpty()) {
                System.out.println("  Este cliente no tiene cuentas registradas.");
            } else {
                for (Cuenta c : cliente.getCuentas()) {
                    System.out.println("  → [" + c.getClass().getSimpleName() + "] "
                            + c.getNumeroCuenta()
                            + " | Saldo: $" + c.getSaldo()
                            + " | Estado: " + c.getEstado().getDescripcion());
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void obtenerTodosLosClientes() {
        System.out.println("--- Todos los Clientes ---");
        java.util.Map<Integer, Cliente> clientes = clienteService.obtenerTodosLosClientesMap();
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            clientes.forEach((id, c) ->
                    System.out.println(id + " | " + c.getNombreCompleto()
                            + " | " + c.getIdentificacion()
                            + " | " + c.getCelular()
                            + " | Bloqueado: " + c.isBloqueado()));
        }
    }

    public void eliminarCliente() {
        System.out.println("--- Eliminar Cliente ---");
        try {
            int id = FormValidationUtil.validateInt("Ingrese el id del cliente a eliminar: ");
            clienteService.eliminarCliente(id);
            System.out.println("Cliente eliminado correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private String pedirCedula() {
        while (true) {
            try {
                String v = FormValidationUtil.validateString("Ingrese la cédula (6-10 dígitos): ");
                return ValidationUtil.validateCedula(v);
            } catch (IllegalArgumentException e) {
                System.out.println("✘ " + e.getMessage());
            }
        }
    }

    private String pedirNombre() {
        while (true) {
            try {
                String v = FormValidationUtil.validateString("Ingrese el nombre completo: ");
                return ValidationUtil.validateNotEmpty(v, "nombre completo");
            } catch (IllegalArgumentException e) {
                System.out.println("✘ " + e.getMessage());
            }
        }
    }

    private String pedirCelular() {
        while (true) {
            try {
                String v = FormValidationUtil.validateString("Ingrese el celular (Ej: 3001234567): ");
                return ValidationUtil.validateCelular(v);
            } catch (IllegalArgumentException e) {
                System.out.println("✘ " + e.getMessage());
            }
        }
    }

    private String pedirUsuario() {
        while (true) {
            try {
                String v = FormValidationUtil.validateString("Ingrese el usuario (mín 4 chars, sin espacios): ");
                return ValidationUtil.validateUsuario(v);
            } catch (IllegalArgumentException e) {
                System.out.println("✘ " + e.getMessage());
            }
        }
    }

    private String pedirContrasena() {
        while (true) {
            try {
                String v = FormValidationUtil.validateString("Ingrese la contraseña (mín 8 chars, 1 mayúscula, 1 número): ");
                return ValidationUtil.validatePassword(v);
            } catch (IllegalArgumentException e) {
                System.out.println("✘ " + e.getMessage());
            }
        }
    }

    private String pedirEmail() {
        while (true) {
            try {
                String v = FormValidationUtil.validateString("Ingrese el email (Ej: nombre@dominio.com): ");
                return ValidationUtil.validateEmail(v);
            } catch (IllegalArgumentException e) {
                System.out.println("✘ " + e.getMessage());
            }
        }
    }

}