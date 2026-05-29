package aplication.service.outputs;

import aplication.domain.TarjetaCredito;
<<<<<<< HEAD
import aplication.domain.enums.EstadoCuenta;

=======
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
import java.util.List;
import java.util.Optional;

public interface TarjetaCreditoService {
    TarjetaCredito crearTarjetaCredito(String numeroCuenta, double cupo, int numeroCuotas);
<<<<<<< HEAD
    TarjetaCredito actualizarTarjetaCredito(String numeroCuenta, double cupo, int numeroCuotas, EstadoCuenta estado);
=======
    TarjetaCredito actualizarTarjetaCredito(String numeroCuenta, double cupo, int numeroCuotas);
>>>>>>> 9693cc793f3497260386310c62640c6de0c83460
    Optional<TarjetaCredito> obtenerPorNumeroCuenta(String numeroCuenta);
    List<TarjetaCredito> obtenerTodas();
    void eliminarTarjetaCredito(String numeroCuenta);
}
