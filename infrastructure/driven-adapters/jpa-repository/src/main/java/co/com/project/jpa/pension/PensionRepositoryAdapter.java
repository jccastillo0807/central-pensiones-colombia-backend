package co.com.project.jpa.pension;

import co.com.project.jpa.helper.AdapterOperations;
import co.com.project.model.pension.Pension;
import co.com.project.model.pension.gateways.PensionRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import static co.com.project.jpa.convertidor.DataMapper.convertirPensionDataAPension;

@Repository
public class PensionRepositoryAdapter extends AdapterOperations<Pension, PensionData, Integer, PensionDataRepository>
        implements PensionRepository {

    public PensionRepositoryAdapter(PensionDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Pension.PensionBuilder.class).build());
    }

    @Override
    public Mono<Pension> consultarDatosCausante(String tipoIdentificacion, String numeroIdentificacion) {
        PensionData usuarioEncontrado = repository.findByTipoIdentificacionAndNumeroIdentificacion(tipoIdentificacion, numeroIdentificacion);
        return Mono.just(convertirPensionDataAPension(usuarioEncontrado));
    }

    @Override
    public Mono<Pension> crearRegistro(Pension pension) {
        return Mono.just(save(pension));
    }
}
