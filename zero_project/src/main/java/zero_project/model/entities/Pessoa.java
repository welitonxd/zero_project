
package zero_project.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table (name="pessoa")
public class Pessoa implements Serializable
{
    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue
    @Column(name="IdPessoa", nullable=false)
    private Integer idPessoa;
    @Column (name="Name", nullable=false, length = 80 )
    private String nome;
    @Column (name="Email", nullable=false, length = 80 )
    private String email;
    @Column (name="Telefone", nullable=false, length = 15 ) //(034)-8888-8888
    private String telefone;
    @Column (name="Cpf", nullable=false, length = 14 )
    private String cpf;
    @Column (name="DataDeNascimento", nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeNascimento;
    @Column (name="DataDeCadastro", nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeCadastro;

    
    @OneToOne (mappedBy="pessoa", fetch= FetchType.LAZY)
    @ForeignKey(name= "Endereco_Pessoa")
    private Endereco endereco;
    
    @ManyToOne (optional= false)
    @ForeignKey(name= "PessoaSexo")
    @JoinColumn(name="IdSexo", referencedColumnName ="IdSexo")
    private Sexo sexo;
    
    public Pessoa() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (this.idPessoa != null ? this.idPessoa.hashCode() : 0);
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
        final Pessoa other = (Pessoa) obj;
        if (this.idPessoa != other.idPessoa && (this.idPessoa == null || !this.idPessoa.equals(other.idPessoa))) {
            return false;
        }
        return true;
    }
    
}
