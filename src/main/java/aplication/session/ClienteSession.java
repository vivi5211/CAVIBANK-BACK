package aplication.session;

import aplication.domain.Cliente;

    public class ClienteSession {

        private static ClienteSession instancia;
        private Cliente clienteActivo;

        private ClienteSession() {}

        public static ClienteSession getInstance() {
            if (instancia == null) {
                instancia = new ClienteSession();
            }
            return instancia;
        }

        public void iniciarSesion(Cliente cliente) {
            this.clienteActivo = cliente;
        }

        public void cerrarSesion() {
            this.clienteActivo = null;
        }

        public Cliente getClienteActivo() {
            return clienteActivo;
        }

        public boolean haySesionActiva() {
            return clienteActivo != null;
        }
    }