package aplication.domain.interfaces;

import aplication.domain.Movimiento;
import java.util.List;

public interface ITransaction {
    void consignar(double monto);
    void retirar(double monto);
    double consultarSaldo();
    List<Movimiento> obtenerMovimientos();
}