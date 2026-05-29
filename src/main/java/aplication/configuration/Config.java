package aplication.configuration;

import aplication.repository.ClienteRepository;
import aplication.repository.CuentaAhorrosRepository;
import aplication.repository.CuentaCorrienteRepository;
import aplication.repository.TarjetaCreditoRepository;
import aplication.service.AuthServiceImpl;
import aplication.service.ClienteServiceImpl;
import aplication.service.CuentaAhorrosServiceImpl;
import aplication.service.CuentaCorrienteServiceImpl;
import aplication.service.TarjetaCreditoServiceImpl;
import aplication.service.outputs.AuthService;
import aplication.service.outputs.ClienteService;
import aplication.service.outputs.CuentaAhorrosService;
import aplication.service.outputs.CuentaCorrienteService;
import aplication.service.outputs.TarjetaCreditoService;
import aplication.service.ports.ClienteRepositoryPort;
import aplication.service.ports.CuentaAhorrosRepositoryPort;
import aplication.service.ports.CuentaCorrienteRepositoryPort;
import aplication.service.ports.TarjetaCreditoRepositoryPort;
import aplication.userinterface.MenuApp;
import aplication.view.ClienteView;
import aplication.view.CuentaAhorrosView;
import aplication.view.CuentaCorrienteView;
import aplication.view.LoginView;
import aplication.view.TarjetaCreditoView;

public class Config {

    public static MenuApp createMenuApp() {

        // Repositorio cliente (implementa ClienteRepositoryPort y AuthRepositoryPort)
        ClienteRepository clienteRepository = new ClienteRepository();

        // Auth
        AuthService authService = new AuthServiceImpl(clienteRepository);
        LoginView loginView = new LoginView(authService);

        // Cliente
        ClienteService clienteService = new ClienteServiceImpl(clienteRepository);
        ClienteView clienteView = new ClienteView(clienteService);

        // Cuenta Ahorros
        CuentaAhorrosRepositoryPort ahorrosPort = new CuentaAhorrosRepository();
        CuentaAhorrosService ahorrosService = new CuentaAhorrosServiceImpl(ahorrosPort);
        CuentaAhorrosView ahorrosView = new CuentaAhorrosView(ahorrosService);

        // Cuenta Corriente
        CuentaCorrienteRepositoryPort corrientePort = new CuentaCorrienteRepository();
        CuentaCorrienteService corrienteService = new CuentaCorrienteServiceImpl(corrientePort);
        CuentaCorrienteView corrienteView = new CuentaCorrienteView(corrienteService);

        // Tarjeta Crédito
        TarjetaCreditoRepositoryPort tarjetaPort = new TarjetaCreditoRepository();
        TarjetaCreditoService tarjetaService = new TarjetaCreditoServiceImpl(tarjetaPort);
        TarjetaCreditoView tarjetaView = new TarjetaCreditoView(tarjetaService);

        return new MenuApp(loginView, clienteView, ahorrosView, corrienteView, tarjetaView);
    }
}