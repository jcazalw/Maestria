/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package foo.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jcazalw
 */
@Entity
@Table(name = "migra_basicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MigraBasicos.findAll", query = "SELECT m FROM MigraBasicos m"),
    @NamedQuery(name = "MigraBasicos.findById", query = "SELECT m FROM MigraBasicos m WHERE m.id = :id"),
    @NamedQuery(name = "MigraBasicos.findByColorId", query = "SELECT m FROM MigraBasicos m WHERE m.colorId = :colorId"),
    @NamedQuery(name = "MigraBasicos.findByColor", query = "SELECT m FROM MigraBasicos m WHERE m.color = :color"),
    @NamedQuery(name = "MigraBasicos.findByMarcaId", query = "SELECT m FROM MigraBasicos m WHERE m.marcaId = :marcaId"),
    @NamedQuery(name = "MigraBasicos.findByGrupoId", query = "SELECT m FROM MigraBasicos m WHERE m.grupoId = :grupoId"),
    @NamedQuery(name = "MigraBasicos.findByPronto", query = "SELECT m FROM MigraBasicos m WHERE m.pronto = :pronto"),
    @NamedQuery(name = "MigraBasicos.findByReferencia", query = "SELECT m FROM MigraBasicos m WHERE m.referencia = :referencia"),
    @NamedQuery(name = "MigraBasicos.findByCantidad", query = "SELECT m FROM MigraBasicos m WHERE m.cantidad = :cantidad"),
    @NamedQuery(name = "MigraBasicos.findByPresentacion", query = "SELECT m FROM MigraBasicos m WHERE m.presentacion = :presentacion"),
    @NamedQuery(name = "MigraBasicos.findByPesoEspecifico", query = "SELECT m FROM MigraBasicos m WHERE m.pesoEspecifico = :pesoEspecifico"),
    @NamedQuery(name = "MigraBasicos.findByPesoLiquido", query = "SELECT m FROM MigraBasicos m WHERE m.pesoLiquido = :pesoLiquido"),
    @NamedQuery(name = "MigraBasicos.findByPesoBruto", query = "SELECT m FROM MigraBasicos m WHERE m.pesoBruto = :pesoBruto")})
public class MigraBasicos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "color_id")
    private Integer colorId;
    @Size(max = 64)
    @Column(name = "color")
    private String color;
    @Column(name = "marca_id")
    private Short marcaId;
    @Column(name = "grupo_id")
    private Short grupoId;
    @Column(name = "pronto")
    private Short pronto;
    @Size(max = 64)
    @Column(name = "referencia")
    private String referencia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    @Column(name = "presentacion")
    private BigDecimal presentacion;
    @Column(name = "peso_especifico")
    private BigDecimal pesoEspecifico;
    @Column(name = "peso_liquido")
    private BigDecimal pesoLiquido;
    @Column(name = "peso_bruto")
    private BigDecimal pesoBruto;

    public MigraBasicos() {
    }

    public MigraBasicos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Short getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Short marcaId) {
        this.marcaId = marcaId;
    }

    public Short getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Short grupoId) {
        this.grupoId = grupoId;
    }

    public Short getPronto() {
        return pronto;
    }

    public void setPronto(Short pronto) {
        this.pronto = pronto;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(BigDecimal presentacion) {
        this.presentacion = presentacion;
    }

    public BigDecimal getPesoEspecifico() {
        return pesoEspecifico;
    }

    public void setPesoEspecifico(BigDecimal pesoEspecifico) {
        this.pesoEspecifico = pesoEspecifico;
    }

    public BigDecimal getPesoLiquido() {
        return pesoLiquido;
    }

    public void setPesoLiquido(BigDecimal pesoLiquido) {
        this.pesoLiquido = pesoLiquido;
    }

    public BigDecimal getPesoBruto() {
        return pesoBruto;
    }

    public void setPesoBruto(BigDecimal pesoBruto) {
        this.pesoBruto = pesoBruto;
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
        if (!(object instanceof MigraBasicos)) {
            return false;
        }
        MigraBasicos other = (MigraBasicos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.MigraBasicos[ id=" + id + " ]";
    }
    
}
