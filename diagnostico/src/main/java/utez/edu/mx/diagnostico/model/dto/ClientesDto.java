package utez.edu.mx.diagnostico.model.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ClientesDto    {
    private Integer id_cliente;
    private String nombre;
    private String apellidos;
    private String curp;
    private String f_nacimiento;
}
