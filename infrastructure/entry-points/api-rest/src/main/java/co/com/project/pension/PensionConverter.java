package co.com.project.pension;

import co.com.project.model.pension.Pension;
import co.com.project.pension.dto.PensionDTO;

public class PensionConverter {
    private PensionConverter() {
    }

    public static PensionDTO construirRespuesta(Pension pension){
        PensionDTO pensionDTO = new PensionDTO();
        pensionDTO.setId(pension.getId());
        pensionDTO.setTipoIdentificacion(pension.getTipoIdentificacion());
        pensionDTO.setNumeroIdentificacion(pension.getNumeroIdentificacion());
        pensionDTO.setFechaAfiliacion(pension.getFechaAfiliacion());
        pensionDTO.setCompaniaPensiones(pension.getCompaniaPensiones());
        pensionDTO.setIdAfiliacion(pension.getIdAfiliacion());
        pensionDTO.setMesesCotizados(pension.getMesesCotizados());
        pensionDTO.setSalario(pension.getSalario());
        return pensionDTO;
    }
}
