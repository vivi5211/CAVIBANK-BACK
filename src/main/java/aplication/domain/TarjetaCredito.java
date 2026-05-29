package aplication.domain;

import aplication.domain.enums.EstadoCuenta;
import aplication.domain.enums.TipoMovimiento;
import aplication.domain.interfaces.ITransferible;
import java.time.LocalDateTime;

public class TarjetaCredito extends Cuenta implements ITransferible {

    private double cupo;
    private double deuda;
    private int numeroCuotas;

    public TarjetaCredito() {}

    public TarjetaCredito(String numeroCuenta, double saldo, LocalDateTime fechaApertura,
                          EstadoCuenta estado, double cupo, double deuda, int numeroCuotas) {
        super(numeroCuenta, saldo, fechaApertura, estado);
        this.cupo = cupo;
        this.deuda = deuda;
        this.numeroCuotas = numeroCuotas;
    }

    @Override
    public void consignar(double monto) {
        pagar(monto);
    }

    @Override
    public void retirar(double monto) {
        comprar(monto, 1);
    }

    public void comprar(double monto, int cuotas) {
        if (monto > (cupo - deuda)) throw new IllegalArgumentException("Cupo insuficiente.");
        this.deuda += monto;
        this.numeroCuotas = cuotas;
        registrarMovimiento(new Movimiento(movimientos.size() + 1,
                LocalDateTime.now(), TipoMovimiento.COMPRA_TC, monto, saldo,
                "Compra con tarjeta en " + cuotas + " cuotas", this));
    }

    public void pagar(double monto) {
        if (monto > deuda) throw new IllegalArgumentException("El pago supera la deuda.");
        this.deuda -= monto;
        registrarMovimiento(new Movimiento(movimientos.size() + 1,
                LocalDateTime.now(), TipoMovimiento.PAGO_TC, monto, saldo,
                "Pago a tarjeta de crédito", this));
    }

    public double calcularTasa(int cuotas) {
        return cuotas <= 1 ? 0 : cuotas * 0.018;
    }

    public double calcularCuotaMensual() {
        if (numeroCuotas <= 0) return deuda;
        return (deuda * calcularTasa(numeroCuotas)) / (1 - Math.pow(1 + calcularTasa(numeroCuotas), -numeroCuotas));
    }

    @Override
    public void transferir(Cuenta destino, double monto) {
        if (!validarDestino(destino)) throw new IllegalArgumentException("Destino no válido.");
        pagar(monto);
        destino.consignar(monto);
    }

    @Override
    public boolean validarDestino(Cuenta c) {
        return c != null && !c.getNumeroCuenta().equals(this.numeroCuenta);
    }

    public double getCupo() { return cupo; }
    public void setCupo(double cupo) { this.cupo = cupo; }
    public double getDeuda() { return deuda; }
    public void setDeuda(double deuda) { this.deuda = deuda; }
    public int getNumeroCuotas() { return numeroCuotas; }
    public void setNumeroCuotas(int numeroCuotas) { this.numeroCuotas = numeroCuotas; }
<<<<<<< HEAD

    private int clienteId;
    public int getClienteId() { return clienteId; }
    public void setClienteId(int clienteId) { this.clienteId = clienteId; }

    @Override
    public String toString() {
        return "TarjetaCredito{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", cupo=$" + cupo +
                ", deuda=$" + deuda +
                ", cuotas=" + numeroCuotas +
                ", estado=" + estado.getDescripcion() +
                ", clienteId=" + clienteId +
                '}';
    }
=======
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
}