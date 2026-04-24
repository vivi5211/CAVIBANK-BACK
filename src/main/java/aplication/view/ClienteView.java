package aplication.view;

import aplication.domain.Cliente;
import aplication.service.outputs.ClienteService;
import aplication.util.FormValidationUtil;
import java.util.List;

public class ClienteView {

    private final ClienteService clienteService;

    public ClienteView(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void crearCliente() {
        System.out.println("--- Crear Cliente ---");
        try {
            int id = FormValidationUtil.validateInt("Ingrese el id del cliente");
            String identificacion = FormValidationUtil.validateString("Ingrese la identificacion");
            String nombreCompleto = FormValidationUtil.validateString("Ingrese el nombre completo");
            String celular = FormValidationUtil.validateString("Ingrese el celular");
            String usuario = FormValidationUtil.validateString("Ingrese el usuario");
            String contrasena = FormValidationUtil.validateString("Ingrese la contrasena");
            Cliente creado = clienteService.crearCliente(id, identificacion, nombreCompleto, celular, usuario, contrasena);
            System.out.println("Cliente creado: " + creado);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void actualizarCliente() {
        System.out.println("--- Actualizar Cliente ---");
        try {
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
            System.out.println("Cliente actualizado: " + actualizado);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void obtenerClientePorId() {
        System.out.println("--- Buscar Cliente por Id ---");
        try {
            int id = FormValidationUtil.validateInt("Ingrese el id del cliente");
            Cliente cliente = clienteService.obtenerClientePorId(id)
                    .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado."));
            System.out.println(cliente);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void obtenerTodosLosClientes() {
        System.out.println("--- Todos los Clientes ---");
        List<Cliente> clientes = clienteService.obtenerTodosLosClientes();
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (Cliente c : clientes) {
                System.out.println(c.getId() + " | " + c.getNombreCompleto() + " | " +
                        c.getIdentificacion() + " | " + c.getCelular() + " | Bloqueado: " + c.isBloqueado());
            }
        }
    }

    public void eliminarCliente() {
        System.out.println("--- Eliminar Cliente ---");
        try {
            int id = FormValidationUtil.validateInt("Ingrese el id del cliente a eliminar");
            clienteService.eliminarCliente(id);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
