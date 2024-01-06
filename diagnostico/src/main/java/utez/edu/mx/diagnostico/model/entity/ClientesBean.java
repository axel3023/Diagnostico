package utez.edu.mx.diagnostico.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "clientes")
public class ClientesBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente",unique = true)
    private Integer id_cliente;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "curp",unique = true)
    private String curp;

    @Column(name = "f_nacimiento")
    private String f_nacimiento;

}
