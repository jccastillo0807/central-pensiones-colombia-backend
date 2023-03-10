package co.com.project.pension;

import co.com.project.pension.dto.PensionDTO;
import co.com.project.usecase.pensiones.PensionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pension")
@RequiredArgsConstructor
public class PensionService {

    private final PensionUseCase pensionUseCase;

    @RequestMapping(path = "/buscar-registro",produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<PensionDTO> buscarRegistro(@RequestParam String tipoIdentificacion, @RequestParam String numeroIdentificacion) {
        return pensionUseCase.buscarRegistroPorTipoYNumeroDocumento(tipoIdentificacion, numeroIdentificacion)
                .map(PensionConverter::construirRespuesta);
    }
}
