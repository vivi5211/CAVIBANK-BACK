package aplication.view;

import aplication.domain.Cliente;
<<<<<<< HEAD
import aplication.domain.Cuenta;
import aplication.service.outputs.ClienteService;
import aplication.util.FormValidationUtil;
import aplication.util.ValidationUtil;
=======
import aplication.service.outputs.ClienteService;
import aplication.util.FormValidationUtil;
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
import java.util.List;

public class ClienteView {

    private final ClienteService clienteService;

    public ClienteView(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void crearCliente() {
        System.out.println("--- Crear Cliente ---");
        try {
<<<<<<< HEAD
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
=======
            int id = FormValidationUtil.validateInt("Ingrese el id del cliente");
            String identificacion = FormValidationUtil.validateString("Ingrese la identificacion");
            String nombreCompleto = FormValidationUtil.validateString("Ingrese el nombre completo");
            String celular = FormValidationUtil.validateString("Ingrese el celular");
            String usuario = FormValidationUtil.validateString("Ingrese el usuario");
            String contrasena = FormValidationUtil.validateString("Ingrese la contrasena");
            Cliente creado = clienteService.crearCliente(id, identificacion, nombreCompleto, celular, usuario, contrasena);
            System.out.println("Cliente creado: " + creado);
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void actualizarCliente() {
        System.out.println("--- Actualizar Cliente ---");
        try {
<<<<<<< HEAD
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
=======
            int id = FormValidationUtil.validateInt("Ingrese el id del cliente a actualizar");
            Cliente actual = clienteService.obtenerClientePorId(id)
                    .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado."));
            System.out.println("Datos actuales: " + actual);
            String identificacion = FormValidationUtil.validateString("Nueva identificacion (" + actual.getIdentificacion() + ")");
            String nombreCompleto = FormValidationUtil.validateString("Nuevo nombre (" + actual.getNombreCompleto() + ")");
            String celular = FormValidationUtil.validateString("Nuevo celular (" + actual.getCelular() + ")");
            String usuario = FormValidationUtil.validateString("Nuevo usuario (" + actual.getUsuario() + ")");
            String contrasena = FormValidationUtil.validateString("Nueva contrasena");
            Cliente actualizado = clienteService.actualizarCliente(id, identificacion, nombreCompleto, celular, usuario, contrasena);
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
            System.out.println("Cliente actualizado: " + actualizado);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void obtenerClientePorId() {
        System.out.println("--- Buscar Cliente por Id ---");
        try {
<<<<<<< HEAD
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
=======
            int id = FormValidationUtil.validateInt("Ingrese el id del cliente");
            Cliente cliente = clienteService.obtenerClientePorId(id)
                    .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado."));
            System.out.println(cliente);
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void obtenerTodosLosClientes() {
        System.out.println("--- Todos los Clientes ---");
<<<<<<< HEAD
        java.util.Map<Integer, Cliente> clientes = clienteService.obtenerTodosLosClientesMap();
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            clientes.forEach((id, c) ->
                    System.out.println(id + " | " + c.getNombreCompleto()
                            + " | " + c.getIdentificacion()
                            + " | " + c.getCelular()
                            + " | Bloqueado: " + c.isBloqueado()));
=======
        List<Cliente> clientes = clienteService.obtenerTodosLosClientes();
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (Cliente c : clientes) {
                System.out.println(c.getId() + " | " + c.getNombreCompleto() + " | " +
                        c.getIdentificacion() + " | " + c.getCelular() + " | Bloqueado: " + c.isBloqueado());
            }
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
        }
    }

    public void eliminarCliente() {
        System.out.println("--- Eliminar Cliente ---");
        try {
<<<<<<< HEAD
            int id = FormValidationUtil.validateInt("Ingrese el id del cliente a eliminar: ");
            clienteService.eliminarCliente(id);
            System.out.println("Cliente eliminado correctamente.");
=======
            int id = FormValidationUtil.validateInt("Ingrese el id del cliente a eliminar");
            clienteService.eliminarCliente(id);
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
<<<<<<< HEAD

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
=======
}
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
