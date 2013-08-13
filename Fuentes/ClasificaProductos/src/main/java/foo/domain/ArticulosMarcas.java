/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package foo.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jcazalw
 */
@Entity
@Table(name = "articulos_marcas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArticulosMarcas.findAll", query = "SELECT a FROM ArticulosMarcas a"),
    @NamedQuery(name = "ArticulosMarcas.findById", query = "SELECT a FROM ArticulosMarcas a WHERE a.id = :id"),
    @NamedQuery(name = "ArticulosMarcas.findByMarca", query = "SELECT a FROM ArticulosMarcas a WHERE a.marca = :marca"),
    @NamedQuery(name = "ArticulosMarcas.findByPaisId", query = "SELECT a FROM ArticulosMarcas a WHERE a.paisId = :paisId"),
    @NamedQuery(name = "ArticulosMarcas.findByActivo", query = "SELECT a FROM ArticulosMarcas a WHERE a.activo = :activo")})
public class ArticulosMarcas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pais_id")
    private short paisId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private short activo;

    public ArticulosMarcas() {
    }

    public ArticulosMarcas(Short id) {
        this.id = id;
    }

    public ArticulosMarcas(Short id, String marca, short paisId, short activo) {
        this.id = id;
        this.marca = marca;
        this.paisId = paisId;
        this.activo = activo;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public short getPaisId() {
        return paisId;
    }

    public void setPaisId(short paisId) {
        this.paisId = paisId;
    }

    public short getActivo() {
        return activo;
    }

    public void setActivo(short activo) {
        this.activo = activo;
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
        if (!(object instanceof ArticulosMarcas)) {
            return false;
        }
        ArticulosMarcas other = (ArticulosMarcas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.ArticulosMarcas[ id=" + id + " ]";
    }
    
}
