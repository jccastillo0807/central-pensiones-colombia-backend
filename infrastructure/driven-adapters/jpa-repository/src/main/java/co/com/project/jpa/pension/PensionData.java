package co.com.project.jpa.pension;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "T_MASTER_PENSIONADOS")
public class PensionData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name = "tipo_identificacion")
    private String tipoIdentificacion;

    @NotEmpty
    @Column(name = "numero_identificacion")
    private String numeroIdentificacion;

    @NotEmpty
    @Column(name = "fecha_afiliacion")
    private Date fechaAfiliacion;

    @NotEmpty
    @Column(name = "compania_pensiones")
    private Integer companiaPensiones;

    @NotEmpty
    @Column(name = "id_afiliacion_compania")
    private Integer idAfiliacion;

    @NotEmpty
    @Column(name = "meses_cotizados")
    private Long mesesCotizados;

    @NotEmpty
    @Column(name = "salario")
    private Long salario;
}
