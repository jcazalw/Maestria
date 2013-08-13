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
@Table(name = "condominio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Condominio.findAll", query = "SELECT c FROM Condominio c"),
    @NamedQuery(name = "Condominio.findById", query = "SELECT c FROM Condominio c WHERE c.id = :id"),
    @NamedQuery(name = "Condominio.findByNome", query = "SELECT c FROM Condominio c WHERE c.nome = :nome"),
    @NamedQuery(name = "Condominio.findByApartamento", query = "SELECT c FROM Condominio c WHERE c.apartamento = :apartamento"),
    @NamedQuery(name = "Condominio.findByEmail", query = "SELECT c FROM Condominio c WHERE c.email = :email"),
    @NamedQuery(name = "Condominio.findByTelefone", query = "SELECT c FROM Condominio c WHERE c.telefone = :telefone")})
public class Condominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "condominio_seq")  
    @SequenceGenerator(name="condominio_seq", sequenceName = "condominio_id_seq")  
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "apartamento")
    private String apartamento;
    @Column(name = "email")
    private String email;
    @Column(name = "telefone")
    private String telefone;
    @JoinTable(name = "reserva_espaco", joinColumns = {
        @JoinColumn(name = "condominio_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "espaco_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Espaco> espacoCollection;

    public Condominio() {
    }

    public Condominio(Integer id) {
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

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @XmlTransient
    public Collection<Espaco> getEspacoCollection() {
        return espacoCollection;
    }

    public void setEspacoCollection(Collection<Espaco> espacoCollection) {
        this.espacoCollection = espacoCollection;
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
        if (!(object instanceof Condominio)) {
            return false;
        }
        Condominio other = (Condominio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.Condominio[ id=" + id + " ]";
    }
    
}
