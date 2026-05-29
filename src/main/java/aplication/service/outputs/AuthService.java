package aplication.service.outputs;

import aplication.domain.Cliente;

public interface AuthService {
    Cliente login(String usuario, String contrasena);
    void logout();
}