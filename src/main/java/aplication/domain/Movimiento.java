package aplication.domain;

import aplication.domain.enums.TipoMovimiento;
import java.time.LocalDateTime;

public class Movimiento {

    private int id;
    private LocalDateTime fechaHora;
    private TipoMovimiento tipo;
    private double valor;
    private double saldoPosterior;
    private String descripcion;
    private Cuenta cuenta;

    public Movimiento() {}

    public Movimiento(int id, LocalDateTime fechaHora, TipoMovimiento tipo, double valor,
                      double saldoPosterior, String descripcion, Cuenta cuenta) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.tipo = tipo;
        this.valor = valor;
        this.saldoPosterior = saldoPosterior;
        this.descripcion = descripcion;
        this.cuenta = cuenta;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }
    public TipoMovimiento getTipo() { return tipo; }
    public void setTipo(TipoMovimiento tipo) { this.tipo = tipo; }
    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }
    public double getSaldoPosterior() { return saldoPosterior; }
    public void setSaldoPosterior(double saldoPosterior) { this.saldoPosterior = saldoPosterior; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Cuenta getCuenta() { return cuenta; }
    public void setCuenta(Cuenta cuenta) { this.cuenta = cuenta; }

    @Override
    public String toString() {
        return "Movimiento{id=" + id + ", tipo=" + tipo.getDescripcion() +
                ", valor=" + valor + ", saldoPosterior=" + saldoPosterior +
                ", descripcion='" + descripcion + "'}";
    }
}