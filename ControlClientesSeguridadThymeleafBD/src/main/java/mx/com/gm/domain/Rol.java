package mx.com.gm.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author DrMerlyn
 */
@Entity
@Data
@Table(name="rol")
public class Rol implements Serializable{
    
    private static final long serialVersionIUD = 1L;

    @Id
    @Column(name = "id_rol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRol;
    
    @NotEmpty
    @Column(name = "nombre")
    private String nombre;
    
    
}
