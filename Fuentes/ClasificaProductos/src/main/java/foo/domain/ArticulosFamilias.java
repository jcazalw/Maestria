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
@Table(name = "articulos_familias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArticulosFamilias.findAll", query = "SELECT a FROM ArticulosFamilias a"),
    @NamedQuery(name = "ArticulosFamilias.findById", query = "SELECT a FROM ArticulosFamilias a WHERE a.id = :id"),
    @NamedQuery(name = "ArticulosFamilias.findByFamilia", query = "SELECT a FROM ArticulosFamilias a WHERE a.familia = :familia"),
    @NamedQuery(name = "ArticulosFamilias.findByArticuloFamiliaId", query = "SELECT a FROM ArticulosFamilias a WHERE a.articuloFamiliaId = :articuloFamiliaId"),
    @NamedQuery(name = "ArticulosFamilias.findByNivelId",query = "SELECT a FROM ArticulosFamilias a WHERE a.nivelId.id = :nivelId")})
public class ArticulosFamilias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "familia")
    private String familia;
    @Column(name = "articulo_familia_id")
    private Integer articuloFamiliaId;
    @OneToMany(mappedBy = "articuloFamiliaId")
    private List<MigraProductos> migraProductosList;
    @JoinColumn(name = "nivel_id", referencedColumnName = "id")
    @ManyToOne
    private ArticulosNiveles nivelId;
    @OneToMany(mappedBy = "ancestroId")
    private List<ArticulosFamilias> articulosFamiliasList;
    @JoinColumn(name = "ancestro_id", referencedColumnName = "id")
    @ManyToOne
    private ArticulosFamilias ancestroId;

    public ArticulosFamilias() {
    }

    public ArticulosFamilias(Integer id) {
        this.id = id;
    }

    public ArticulosFamilias(Integer id, String familia) {
        this.id = id;
        this.familia = familia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public Integer getArticuloFamiliaId() {
        return articuloFamiliaId;
    }

    public void setArticuloFamiliaId(Integer articuloFamiliaId) {
        this.articuloFamiliaId = articuloFamiliaId;
    }

    @XmlTransient
    public List<MigraProductos> getMigraProductosList() {
        return migraProductosList;
    }

    public void setMigraProductosList(List<MigraProductos> migraProductosList) {
        this.migraProductosList = migraProductosList;
    }

    public ArticulosNiveles getNivelId() {
        return nivelId;
    }

    public void setNivelId(ArticulosNiveles nivelId) {
        this.nivelId = nivelId;
    }

    @XmlTransient
    public List<ArticulosFamilias> getArticulosFamiliasList() {
        return articulosFamiliasList;
    }

    public void setArticulosFamiliasList(List<ArticulosFamilias> articulosFamiliasList) {
        this.articulosFamiliasList = articulosFamiliasList;
    }

    public ArticulosFamilias getAncestroId() {
        return ancestroId;
    }

    public void setAncestroId(ArticulosFamilias ancestroId) {
        this.ancestroId = ancestroId;
    }
    
    public Integer getPadre(){    	
    	if (this.ancestroId == null)
    		return 0;
    	else return this.ancestroId.getId();
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
        if (!(object instanceof ArticulosFamilias)) {
            return false;
        }
        ArticulosFamilias other = (ArticulosFamilias) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.ArticulosFamilias[ id=" + id + " ]";
    }
    
}
