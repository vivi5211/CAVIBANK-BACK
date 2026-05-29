package aplication.factory;

import aplication.domain.CuentaAhorros;
import aplication.domain.CuentaCorriente;
import aplication.domain.TarjetaCredito;
import aplication.domain.enums.EstadoCuenta;
import java.time.LocalDateTime;

public class CuentaFactory {

    private CuentaFactory() {}

    public static CuentaAhorros crearAhorros(String numeroCuenta, double saldo,
                                             double tasaInteres, int clienteId) {
        CuentaAhorros cuenta = new CuentaAhorros(
                numeroCuenta, saldo, LocalDateTime.now(),
                EstadoCuenta.ACTIVA, tasaInteres);
        cuenta.setClienteId(clienteId);
        return cuenta;
    }

    public static CuentaCorriente crearCorriente(String numeroCuenta, double saldo,
                                                 double porcentajeSobregiro,
                                                 double limiteSobregiro, int clienteId) {
        CuentaCorriente cuenta = new CuentaCorriente(
                numeroCuenta, saldo, LocalDateTime.now(),
                EstadoCuenta.ACTIVA, porcentajeSobregiro, limiteSobregiro);
        cuenta.setClienteId(clienteId);
        return cuenta;
    }

    public static TarjetaCredito crearTarjetaCredito(String numeroCuenta, double cupo,
                                                     int numeroCuotas, int clienteId) {
        TarjetaCredito tarjeta = new TarjetaCredito(
                numeroCuenta, 0, LocalDateTime.now(),
                EstadoCuenta.ACTIVA, cupo, 0, numeroCuotas);
        tarjeta.setClienteId(clienteId);
        return tarjeta;
    }
}