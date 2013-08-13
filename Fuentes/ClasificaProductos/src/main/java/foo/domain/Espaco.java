/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package foo.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jcazalw
 */
@Entity
@Table(name = "espaco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Espaco.findAll", query = "SELECT e FROM Espaco e"),
    @NamedQuery(name = "Espaco.findById", query = "SELECT e FROM Espaco e WHERE e.id = :id"),
    @NamedQuery(name = "Espaco.findByNome", query = "SELECT e FROM Espaco e WHERE e.nome = :nome"),
    @NamedQuery(name = "Espaco.findByValorAluguel", query = "SELECT e FROM Espaco e WHERE e.valorAluguel = :valorAluguel")})
public class Espaco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "espaco_seq")  
    @SequenceGenerator(name="espaco_seq", sequenceName = "espaco_id_seq")  
    private Integer id;
    @Column(name = "nome")
    private String nome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_aluguel")
    private Double valorAluguel;
    @ManyToMany(mappedBy = "espacoCollection")
    private Collection<Condominio> condominioCollection;

    public Espaco() {
    }

    public Espaco(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(Double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    @XmlTransient
    public Collection<Condominio> getCondominioCollection() {
        return condominioCollection;
    }

    public void setCondominioCollection(Collection<Condominio> condominioCollection) {
        this.condominioCollection = condominioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Espaco)) {
            return false;
        }
        Espaco other = (Espaco) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.Espaco[ id=" + id + " ]";
    }
    
}
