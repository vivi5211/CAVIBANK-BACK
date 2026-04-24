package aplication.domain.interfaces;

import aplication.domain.Cuenta;

public interface ITransferible {
    void transferir(Cuenta destino, double monto);
    boolean validarDestino(Cuenta c);
}