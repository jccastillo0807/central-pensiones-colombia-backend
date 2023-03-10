package co.com.project.pension;

import co.com.project.model.pension.Pension;
import co.com.project.pension.dto.PensionDTO;
import co.com.project.usecase.pensiones.PensionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pension")
@RequiredArgsConstructor
public class PensionService {

    private final PensionUseCase pensionUseCase;

    @GetMapping(path = "/buscar-registro", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<PensionDTO> buscarRegistro(@RequestParam String tipoIdentificacion, @RequestParam String numeroIdentificacion) {
        return pensionUseCase.buscarRegistroPorTipoYNumeroDocumento(tipoIdentificacion, numeroIdentificacion)
                .map(PensionConverter::construirRespuesta);
    }


    @PostMapping(path = "crear-registro", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mono<PensionDTO> guardarRegistro(@RequestBody Pension pension) {
        return pensionUseCase.CrearNuevoRegistroPension(pension)
                .map(PensionConverter::construirRespuesta);
    }
}
