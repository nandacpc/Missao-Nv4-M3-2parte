package cadastroee.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Movimento")
@NamedQueries({
    @NamedQuery(name = "Movimento.findAll", query = "SELECT m FROM Movimento m"),
    @NamedQuery(name = "Movimento.findByIDMovimento", query = "SELECT m FROM Movimento m WHERE m.iDMovimento = :iDMovimento"),
    @NamedQuery(name = "Movimento.findByQuantidade", query = "SELECT m FROM Movimento m WHERE m.quantidade = :quantidade"),
    @NamedQuery(name = "Movimento.findByPrecoUnitario", query = "SELECT m FROM Movimento m WHERE m.precoUnitario = :precoUnitario")})
public class Movimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDMovimento")
    private Integer iDMovimento;
    @Column(name = "Quantidade")
    private Integer quantidade;
    @ManyToOne
    @JoinColumn(name = "IDPessoaJuridica", referencedColumnName = "IDPessoa")
    private PessoaJuridica iDPessoaJuridica;
    @ManyToOne
    @JoinColumn(name = "IDPessoaFisica", referencedColumnName = "IDPessoa")
    private PessoaFisica iDPessoaFisica;
    @ManyToOne
    @JoinColumn(name = "IDProduto", referencedColumnName = "IDProduto")
    private Produtos iDProduto;
    @Column(name = "PrecoUnitario")
    private BigDecimal precoUnitario;

    public Movimento() {
    }

    public Movimento(Integer iDMovimento) {
        this.iDMovimento = iDMovimento;
    }

        public Integer getIDMovimento() {
        return iDMovimento;
    }

    public void setIDMovimento(Integer iDMovimento) {
        this.iDMovimento = iDMovimento;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public PessoaFisica getIDPessoaFisica() {
        return iDPessoaFisica;
    }

    public void setIDPessoaFisica(PessoaFisica iDPessoaFisica) {
        this.iDPessoaFisica = iDPessoaFisica;
    }

    public Produtos getIDProduto() {
        return iDProduto;
    }

    public void setIDProduto(Produtos iDProduto) {
        this.iDProduto = iDProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDMovimento != null ? iDMovimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Movimento)) {
            return false;
        }
        Movimento other = (Movimento) object;
        return !((this.iDMovimento == null && other.iDMovimento != null) || (this.iDMovimento != null && !this.iDMovimento.equals(other.iDMovimento)));
    }

    @Override
    public String toString() {
        return "cadastroee.model.Movimento[ iDMovimento=" + iDMovimento + " ]";
    }
}