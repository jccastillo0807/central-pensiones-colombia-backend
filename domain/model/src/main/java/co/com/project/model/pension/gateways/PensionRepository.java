package co.com.project.model.pension.gateways;

import co.com.project.model.pension.Pension;
import reactor.core.publisher.Mono;

public interface PensionRepository {
    Mono<Pension> consultarDatosCausante(String tipoIdentificacion, String numeroIdentificacion);
    /*Mono<Integer> consultarMesesCotizados(String tipoIdentificacion, String numeroIdentificacion);
    Mono<Long> consultarSalarioActual(String tipoIdentificacion, String numeroIdentificacion);*/
    Mono<Pension> crearRegistro(Pension pension);
}
