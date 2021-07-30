package mx.com.gm.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author DrMerlyn
 */
@Entity
@Data
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionIUD = 1L;

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @NotEmpty
    @Column(name="username")
    private String username;

    @NotEmpty
    @Column(name = "password")
    private String password;

    @OneToMany
    @JoinColumn(name = "id_usuario")
    private List<Rol> roles;   
    
    
    
    
}
