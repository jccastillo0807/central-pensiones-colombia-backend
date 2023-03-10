package co.com.project.usecase.pensiones;

import co.com.project.model.pension.Pension;
import co.com.project.model.pension.gateways.PensionRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class PensionUseCase {
    private final PensionRepository pensionRepository;

    public Mono<Pension> buscarRegistroPorTipoYNumeroDocumento(String tipoDocumento, String nroDocumento) {
       return pensionRepository.consultarDatosCausante(tipoDocumento,nroDocumento);
    }

    public Mono<Pension> CrearNuevoRegistroPension(Pension pension){
        return pensionRepository.crearRegistro(pension);
    }
}
