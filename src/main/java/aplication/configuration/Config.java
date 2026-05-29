package aplication.configuration;

import aplication.repository.ClienteRepository;
import aplication.repository.CuentaAhorrosRepository;
import aplication.repository.CuentaCorrienteRepository;
import aplication.repository.TarjetaCreditoRepository;
<<<<<<< HEAD
import aplication.service.AuthServiceImpl;
=======
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
import aplication.service.ClienteServiceImpl;
import aplication.service.CuentaAhorrosServiceImpl;
import aplication.service.CuentaCorrienteServiceImpl;
import aplication.service.TarjetaCreditoServiceImpl;
<<<<<<< HEAD
import aplication.service.outputs.AuthService;
=======
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
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
<<<<<<< HEAD
import aplication.view.LoginView;
=======
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
import aplication.view.TarjetaCreditoView;

public class Config {

    public static MenuApp createMenuApp() {

<<<<<<< HEAD
        // Repositorio cliente (implementa ClienteRepositoryPort y AuthRepositoryPort)
        ClienteRepository clienteRepository = new ClienteRepository();

        // Auth
        AuthService authService = new AuthServiceImpl(clienteRepository);
        LoginView loginView = new LoginView(authService);

        // Cliente
        ClienteService clienteService = new ClienteServiceImpl(clienteRepository);
=======
        // Cliente
        ClienteRepositoryPort clientePort = new ClienteRepository();
        ClienteService clienteService = new ClienteServiceImpl(clientePort);
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
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

<<<<<<< HEAD
        return new MenuApp(loginView, clienteView, ahorrosView, corrienteView, tarjetaView);
=======
        return new MenuApp(clienteView, ahorrosView, corrienteView, tarjetaView);
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
    }
}