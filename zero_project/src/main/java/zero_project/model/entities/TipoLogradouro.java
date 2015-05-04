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
@Table (name="tipologradouro")
public class TipoLogradouro implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name="IdTipoLogradouro", nullable=false)
    private Integer IdTipoLogradouro;
    @Column (name="DescricaoTipoLogradouro", length= 40, nullable=false)
    private String descricaoTipoLogradouro;
    
    @OneToMany (mappedBy= "tipologradouro", fetch =FetchType.LAZY)
    @ForeignKey(name="Endereco_TipoLogradouro")
    private List<Endereco> enderecos;

    public TipoLogradouro() {
    }

    public Integer getIdTipoLogradouro() {
        return IdTipoLogradouro;
    }

    public void setIdTipoLogradouro(Integer IdTipoLogradouro) {
        this.IdTipoLogradouro = IdTipoLogradouro;
    }

    public String getDescricaoTipoLogradouro() {
        return descricaoTipoLogradouro;
    }

    public void setDescricaoTipoLogradouro(String descricaoTipoLogradouro) {
        this.descricaoTipoLogradouro = descricaoTipoLogradouro;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.IdTipoLogradouro != null ? this.IdTipoLogradouro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoLogradouro other = (TipoLogradouro) obj;
        if (this.IdTipoLogradouro != other.IdTipoLogradouro && (this.IdTipoLogradouro == null || !this.IdTipoLogradouro.equals(other.IdTipoLogradouro))) {
            return false;
        }
        return true;
    }
    
    
}
