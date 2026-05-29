package aplication.domain;

import aplication.domain.enums.EstadoCuenta;
import aplication.domain.enums.TipoMovimiento;
import aplication.domain.interfaces.ITransferible;
import java.time.LocalDateTime;

public class CuentaCorriente extends Cuenta implements ITransferible {

    private double porcentajeSobregiro;
    private double limiteSobregiro;

    public CuentaCorriente() {}

    public CuentaCorriente(String numeroCuenta, double saldo, LocalDateTime fechaApertura,
                           EstadoCuenta estado, double porcentajeSobregiro, double limiteSobregiro) {
        super(numeroCuenta, saldo, fechaApertura, estado);
        this.porcentajeSobregiro = porcentajeSobregiro;
        this.limiteSobregiro = limiteSobregiro;
    }

    @Override
    public void consignar(double monto) {
        this.saldo += monto;
        registrarMovimiento(new Movimiento(movimientos.size() + 1,
                LocalDateTime.now(), TipoMovimiento.CONSIGNACION, monto, saldo,
                "Consignación en cuenta corriente", this));
    }

    @Override
    public void retirar(double monto) {
        double disponible = saldo + calcularLimiteSobregiro();
        if (monto > disponible) throw new IllegalArgumentException("Supera el límite disponible con sobregiro.");
        this.saldo -= monto;
        registrarMovimiento(new Movimiento(movimientos.size() + 1,
                LocalDateTime.now(), TipoMovimiento.RETIRO, monto, saldo,
                "Retiro en cuenta corriente", this));
    }

    public double calcularLimiteSobregiro() {
        return saldo * (porcentajeSobregiro / 100);
    }

    @Override
    public void transferir(Cuenta destino, double monto) {
        if (!validarDestino(destino)) throw new IllegalArgumentException("Destino no válido.");
        retirar(monto);
        destino.consignar(monto);
    }

    @Override
    public boolean validarDestino(Cuenta c) {
        return c != null && !c.getNumeroCuenta().equals(this.numeroCuenta);
    }

    public double getPorcentajeSobregiro() { return porcentajeSobregiro; }
    public void setPorcentajeSobregiro(double p) { this.porcentajeSobregiro = p; }
    public double getLimiteSobregiro() { return limiteSobregiro; }
    public void setLimiteSobregiro(double l) { this.limiteSobregiro = l; }

    @Override
    public String toString() {
        return "CuentaCorriente{numeroCuenta='" + numeroCuenta + "', saldo=" + saldo +
                ", sobregiro=" + porcentajeSobregiro + "%, limite=" + limiteSobregiro +
                ", estado=" + estado.getDescripcion() + "}";
    }
<<<<<<< HEAD

    private int clienteId;
    public int getClienteId() { return clienteId; }
    public void setClienteId(int clienteId) { this.clienteId = clienteId; }
=======
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
}