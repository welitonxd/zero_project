package zero_project.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
    
    @OneToOne (optional=true, fetch= FetchType.LAZY)
    @ForeignKey(name="Endereco_Pessoa")
    @JoinColumn (name="IdPessoa", referencedColumnName= "IdPessoa")
    private Pessoa pessoa;
    
    @ManyToOne (optional=false, fetch= FetchType.LAZY)
    @ForeignKey(name="EnderecoTipoLogradouro")
    @JoinColumn(name="IdTipoLogradouro", referencedColumnName ="IdTipoLogradouro" )
    private TipoLogradouro tipoLogradouro;
    
    @ManyToOne (optional=false, fetch= FetchType.LAZY)
    @ForeignKey(name="EstadoEndereco")
    @JoinColumn(name="IdEstado", nullable=false )
    private Estado estado;
    
    @ManyToOne (optional=false, fetch= FetchType.LAZY)
    @ForeignKey(name="Endereco_TipoEndereco")
    @JoinColumn(name="IdTipoEndereco", referencedColumnName ="IdTipoEndereco" )
    private TipoEndereco tipoEndereco;
    
    @ManyToOne (optional=false, fetch= FetchType.LAZY)
    @ForeignKey(name="CidadeEndereco")
    @JoinColumn(name="IdCidade", referencedColumnName ="IdCidade" )
    private Cidade cidade;
    
    @CMany

    public Endereco() {
        this.cidade = new Cidade();
        this.estado = new Estado();
        this.tipoLogradouro = new TipoLogradouro();
        this.tipoEndereco = new TipoEndereco();
        this.pessoa = new Pessoa();
    }

    public Integer getIdEndereco() {
        return IdEndereco;
    }

    public void setIdEndereco(Integer IdEndereco) {
        this.IdEndereco = IdEndereco;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getComplemento() {
        return complemento;
    }

    public void setComplemento(Integer complemento) {
        this.complemento = complemento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.IdEndereco != null ? this.IdEndereco.hashCode() : 0);
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
        final Endereco other = (Endereco) obj;
        if (this.IdEndereco != other.IdEndereco && (this.IdEndereco == null || !this.IdEndereco.equals(other.IdEndereco))) {
            return false;
        }
        return true;
    }
    
}
