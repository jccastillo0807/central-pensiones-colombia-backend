package co.com.project.jpa.pension;

import co.com.project.jpa.helper.AdapterOperations;
import co.com.project.model.pension.Pension;
import co.com.project.model.pension.gateways.PensionRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.Objects;

import static co.com.project.jpa.convertidor.DataMapper.convertirPensionDataAPension;

@Repository
public class PensionRepositoryAdapter extends AdapterOperations<Pension, PensionData, Integer, PensionDataRepository>
        implements PensionRepository {

    public PensionRepositoryAdapter(PensionDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Pension.PensionBuilder.class).build());
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<Pension> consultarDatosCausante(String tipoIdentificacion, String numeroIdentificacion) {
        if (tipoIdentificacion.equalsIgnoreCase("") || numeroIdentificacion.equalsIgnoreCase("")
                || numeroIdentificacion.isEmpty() || tipoIdentificacion.isEmpty()){
            return Mono.empty();
        }
        PensionData usuarioEncontrado = repository.findByTipoIdentificacionAndNumeroIdentificacion(tipoIdentificacion, numeroIdentificacion);
        if (Objects.isNull(usuarioEncontrado)){
            return Mono.empty();
        }
        return Mono.just(convertirPensionDataAPension(usuarioEncontrado));
    }

    @Override
    public Mono<Pension> crearRegistro(Pension pension) {
        if ( Objects.isNull(pension)) {
           return Mono.empty();
        }
        return Mono.just(save(pension));
    }
}
