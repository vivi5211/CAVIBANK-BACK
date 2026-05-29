package aplication.service.outputs;

import aplication.domain.CuentaCorriente;
<<<<<<< HEAD
import aplication.domain.enums.EstadoCuenta;

=======
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
import java.util.List;
import java.util.Optional;

public interface CuentaCorrienteService {
    CuentaCorriente crearCuentaCorriente(String numeroCuenta, double saldo,
                                         double porcentajeSobregiro, double limiteSobregiro);
<<<<<<< HEAD
    CuentaCorriente actualizarCuentaCorriente(String numeroCuenta, double porcentajeSobregiro,
                                              double limiteSobregiro, EstadoCuenta estado);
=======
    CuentaCorriente actualizarCuentaCorriente(String numeroCuenta,
                                              double porcentajeSobregiro, double limiteSobregiro);
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
    Optional<CuentaCorriente> obtenerPorNumeroCuenta(String numeroCuenta);
    List<CuentaCorriente> obtenerTodas();
    void eliminarCuentaCorriente(String numeroCuenta);
}
