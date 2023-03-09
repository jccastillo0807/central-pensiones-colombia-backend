package co.com.project.model.pension;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Pension {
    private Integer id;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private Date fechaAfiliacion;
    private Integer companiaPensiones;
    private Integer idAfiliacion;
    private Long mesesCotizados;
    private Long salario;

}
