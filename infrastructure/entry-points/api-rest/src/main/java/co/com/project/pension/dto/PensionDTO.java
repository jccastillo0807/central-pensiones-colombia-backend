package co.com.project.pension.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class PensionDTO {
     Integer id;
     String tipoIdentificacion;
     String numeroIdentificacion;
     Date fechaAfiliacion;
     Integer companiaPensiones;
     Integer idAfiliacion;
     Long mesesCotizados;
     Long salario;
}
