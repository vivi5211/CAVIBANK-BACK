package aplication.domain;

import aplication.domain.enums.EstadoCuenta;
import aplication.domain.enums.TipoMovimiento;
import aplication.domain.interfaces.ITransferible;
import java.time.LocalDateTime;

public class CuentaAhorros extends Cuenta implements ITransferible {

    private double tasaInteres;

    public CuentaAhorros() {}

    public CuentaAhorros(String numeroCuenta, double saldo, LocalDateTime fechaApertura,
                         EstadoCuenta estado, double tasaInteres) {
        super(numeroCuenta, saldo, fechaApertura, estado);
        this.tasaInteres = tasaInteres;
    }

    @Override
    public void consignar(double monto) {
        if (monto <= 0) throw new IllegalArgumentException("El monto debe ser mayor a 0.");
        this.saldo += monto;
        registrarMovimiento(new Movimiento(movimientos.size() + 1,
                LocalDateTime.now(), TipoMovimiento.CONSIGNACION, monto, saldo,
                "Consignacion en cuenta de ahorros", this));
    }

    @Override
    public void retirar(double monto) {
        if (monto <= 0) throw new IllegalArgumentException("El monto debe ser mayor a 0.");
        if (monto > saldo) throw new IllegalArgumentException("Saldo insuficiente.");
        this.saldo -= monto;
        registrarMovimiento(new Movimiento(movimientos.size() + 1,
                LocalDateTime.now(), TipoMovimiento.RETIRO, monto, saldo,
                "Retiro en cuenta de ahorros", this));
    }

    public void aplicarIntereses() {
        double intereses = calcularIntereses();
        this.saldo += intereses;
        System.out.println("Intereses aplicados: $" + intereses);
    }

    public double calcularIntereses() {
        return saldo * (tasaInteres / 100);
    }

    @Override
    public void transferir(Cuenta destino, double monto) {
        if (!validarDestino(destino)) throw new IllegalArgumentException("Destino no valido.");
        retirar(monto);
        destino.consignar(monto);
        registrarMovimiento(new Movimiento(movimientos.size() + 1,
                LocalDateTime.now(), TipoMovimiento.TRANSFERENCIA_OUT, monto, saldo,
                "Transferencia a cuenta " + destino.getNumeroCuenta(), this));
    }

    @Override
    public boolean validarDestino(Cuenta c) {
        return c != null && !c.getNumeroCuenta().equals(this.numeroCuenta);
    }

    public double getTasaInteres() { return tasaInteres; }
    public void setTasaInteres(double tasaInteres) { this.tasaInteres = tasaInteres; }

    @Override
    public String toString() {
        return "CuentaAhorros{numeroCuenta='" + numeroCuenta + "', saldo=" + saldo +
                ", tasaInteres=" + tasaInteres + "%, estado=" + estado.getDescripcion() + "}";
    }
<<<<<<< HEAD

    private int clienteId;
    public int getClienteId() { return clienteId; }
    public void setClienteId(int clienteId) { this.clienteId = clienteId; }
=======
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
}
