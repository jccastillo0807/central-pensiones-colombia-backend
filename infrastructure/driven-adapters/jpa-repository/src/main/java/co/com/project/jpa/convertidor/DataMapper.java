package co.com.project.jpa.convertidor;

import co.com.project.jpa.pension.PensionData;
import co.com.project.model.pension.Pension;

public class DataMapper {

    private DataMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static Pension convertirPensionDataAPension(PensionData pensionData) {
        return Pension.builder()
                .id(pensionData.getId())
                .tipoIdentificacion(pensionData.getTipoIdentificacion())
                .numeroIdentificacion(pensionData.getNumeroIdentificacion())
                .fechaAfiliacion(pensionData.getFechaAfiliacion())
                .companiaPensiones(pensionData.getCompaniaPensiones())
                .idAfiliacion(pensionData.getIdAfiliacion())
                .mesesCotizados(pensionData.getMesesCotizados())
                .salario(pensionData.getSalario())
                .build();
    }

    public static PensionData convertirPensionAPensionData(Pension pension) {
        return PensionData.builder()
                .id(pension.getId())
                .tipoIdentificacion(pension.getTipoIdentificacion())
                .numeroIdentificacion(pension.getNumeroIdentificacion())
                .fechaAfiliacion(pension.getFechaAfiliacion())
                .companiaPensiones(pension.getCompaniaPensiones())
                .idAfiliacion(pension.getIdAfiliacion())
                .mesesCotizados(pension.getMesesCotizados())
                .salario(pension.getSalario())
                .build();
    }
}
