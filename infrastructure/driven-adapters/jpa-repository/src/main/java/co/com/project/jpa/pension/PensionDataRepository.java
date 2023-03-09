package co.com.project.jpa.pension;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface PensionDataRepository extends CrudRepository<PensionData, Integer>, QueryByExampleExecutor<PensionData> {
    PensionData findByTipoIdentificacionAndNumeroIdentificacion(String tipoIdentificacion, String numeroIdentificacion);
}
