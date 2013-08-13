/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package foo.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jcazalw
 */
@Entity
@Table(name = "articulos_niveles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArticulosNiveles.findAll", query = "SELECT a FROM ArticulosNiveles a"),
    @NamedQuery(name = "ArticulosNiveles.findById", query = "SELECT a FROM ArticulosNiveles a WHERE a.id = :id"),
    @NamedQuery(name = "ArticulosNiveles.findByNivel", query = "SELECT a FROM ArticulosNiveles a WHERE a.nivel = :nivel")})
public class ArticulosNiveles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "nivel")
    private String nivel;
    @OneToMany(mappedBy = "ancestroId")
    private List<ArticulosNiveles> articulosNivelesList;
    @JoinColumn(name = "ancestro_id", referencedColumnName = "id")
    @ManyToOne
    private ArticulosNiveles ancestroId;
    @OneToMany(mappedBy = "nivelId")
    private List<ArticulosFamilias> articulosFamiliasList;

    public ArticulosNiveles() {
    }

    public ArticulosNiveles(Integer id) {
        this.id = id;
    }

    public ArticulosNiveles(Integer id, String nivel) {
        this.id = id;
        this.nivel = nivel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @XmlTransient
    public List<ArticulosNiveles> getArticulosNivelesList() {
        return articulosNivelesList;
    }

    public void setArticulosNivelesList(List<ArticulosNiveles> articulosNivelesList) {
        this.articulosNivelesList = articulosNivelesList;
    }

    public ArticulosNiveles getAncestroId() {
        return ancestroId;
    }

    public void setAncestroId(ArticulosNiveles ancestroId) {
        this.ancestroId = ancestroId;
    }

    @XmlTransient
    public List<ArticulosFamilias> getArticulosFamiliasList() {
        return articulosFamiliasList;
    }

    public void setArticulosFamiliasList(List<ArticulosFamilias> articulosFamiliasList) {
        this.articulosFamiliasList = articulosFamiliasList;
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
        if (!(object instanceof ArticulosNiveles)) {
            return false;
        }
        ArticulosNiveles other = (ArticulosNiveles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.ArticulosNiveles[ id=" + id + " ]";
    }
    
}
