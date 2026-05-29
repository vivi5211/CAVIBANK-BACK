package aplication.domain;

import aplication.domain.enums.EstadoCuenta;
import aplication.domain.interfaces.ITransaction;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Cuenta implements ITransaction {

    //atributos

    protected String numeroCuenta;
    protected double saldo;
    protected LocalDateTime fechaApertura;
    protected EstadoCuenta estado;
    protected List<Movimiento> movimientos;


    // constructores

    public Cuenta() {}

    public Cuenta(String numeroCuenta, double saldo, LocalDateTime fechaApertura, EstadoCuenta estado) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
        this.estado = estado;
        this.movimientos = new ArrayList<>();
    }

    // Implementación base de ITransaction
    @Override
    public double consultarSaldo() {
        return saldo;
    }

    @Override
    public List<Movimiento> obtenerMovimientos() {
        return movimientos;
    }

    public void registrarMovimiento(Movimiento m) {
        movimientos.add(m);
    }

    // retirar y consignar son abstractos — cada cuenta los implementa diferente
    @Override
    public abstract void consignar(double monto);

    @Override
    public abstract void retirar(double monto);

    // Getters y Setters
    public String getNumeroCuenta() { return numeroCuenta; }
    public void setNumeroCuenta(String numeroCuenta) { this.numeroCuenta = numeroCuenta; }
    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }
    public LocalDateTime getFechaApertura() { return fechaApertura; }
    public void setFechaApertura(LocalDateTime fechaApertura) { this.fechaApertura = fechaApertura; }
    public EstadoCuenta getEstado() { return estado; }
    public void setEstado(EstadoCuenta estado) { this.estado = estado; }
    public void setMovimientos(List<Movimiento> movimientos) { this.movimientos = movimientos; }
}