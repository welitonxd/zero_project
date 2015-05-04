package zero_project.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table (name="endereco")
public class Endereco implements Serializable {
    
    private static final long serialVersionUID =1L;
    
    @Id
    @GeneratedValue
    @Column(name="IdEndereco", nullable=false)
    private Integer IdEndereco;
    @Column (name="Bairro", length= 80)    
    private String Bairro;
    @Column (name="NomeLogradouro", length= 180)
    private String nomeLogradouro;
    @Column (name="CEP", length= 9)
    private String cep;
    @Column (name="Numero", length= 9)
    private Integer numero;
    @Column (name="Complemento")
    private Integer complemento;
    
    @OneToMany (mappedBy= "tipologradouro", fetch =FetchType.LAZY)
    @ForeignKey(name="Endereco_TipoLogradouro")
    private List<Endereco> enderecos;
    
}
