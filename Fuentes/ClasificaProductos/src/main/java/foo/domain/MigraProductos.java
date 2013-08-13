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
@Table(name = "migra_productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MigraProductos.findAll", query = "SELECT m FROM MigraProductos m"),
    @NamedQuery(name = "MigraProductos.findByCodigoNum", query = "SELECT m FROM MigraProductos m WHERE m.codigoNum = :codigoNum"),
    @NamedQuery(name = "MigraProductos.findByCodigo", query = "SELECT m FROM MigraProductos m WHERE m.codigo = :codigo"),
    @NamedQuery(name = "MigraProductos.findByCodBarra", query = "SELECT m FROM MigraProductos m WHERE m.codBarra = :codBarra"),
    @NamedQuery(name = "MigraProductos.findByDescripcion", query = "SELECT m FROM MigraProductos m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "MigraProductos.findByPrecioVenta", query = "SELECT m FROM MigraProductos m WHERE m.precioVenta = :precioVenta"),
    @NamedQuery(name = "MigraProductos.findByPrecioDistribuidor", query = "SELECT m FROM MigraProductos m WHERE m.precioDistribuidor = :precioDistribuidor"),
    @NamedQuery(name = "MigraProductos.findByPrecioCosto", query = "SELECT m FROM MigraProductos m WHERE m.precioCosto = :precioCosto"),
    @NamedQuery(name = "MigraProductos.findByPorcMostrador", query = "SELECT m FROM MigraProductos m WHERE m.porcMostrador = :porcMostrador"),
    @NamedQuery(name = "MigraProductos.findByPorcDistribuidor", query = "SELECT m FROM MigraProductos m WHERE m.porcDistribuidor = :porcDistribuidor"),
    @NamedQuery(name = "MigraProductos.findByIdRubro", query = "SELECT m FROM MigraProductos m WHERE m.idRubro = :idRubro"),
    @NamedQuery(name = "MigraProductos.findByIdRubro1", query = "SELECT m FROM MigraProductos m WHERE m.idRubro1 = :idRubro1"),
    @NamedQuery(name = "MigraProductos.findByIdRubro2", query = "SELECT m FROM MigraProductos m WHERE m.idRubro2 = :idRubro2"),
    @NamedQuery(name = "MigraProductos.findByMarca", query = "SELECT m FROM MigraProductos m WHERE m.marca = :marca"),
    @NamedQuery(name = "MigraProductos.findBySuspendido", query = "SELECT m FROM MigraProductos m WHERE m.suspendido = :suspendido"),
    @NamedQuery(name = "MigraProductos.findByTipoImpuesto", query = "SELECT m FROM MigraProductos m WHERE m.tipoImpuesto = :tipoImpuesto"),
    @NamedQuery(name = "MigraProductos.findByProveedor", query = "SELECT m FROM MigraProductos m WHERE m.proveedor = :proveedor"),
    @NamedQuery(name = "MigraProductos.findByCalcularStock", query = "SELECT m FROM MigraProductos m WHERE m.calcularStock = :calcularStock"),
    @NamedQuery(name = "MigraProductos.findByStockMinimo", query = "SELECT m FROM MigraProductos m WHERE m.stockMinimo = :stockMinimo"),
    @NamedQuery(name = "MigraProductos.findByCodMedida", query = "SELECT m FROM MigraProductos m WHERE m.codMedida = :codMedida"),
    @NamedQuery(name = "MigraProductos.findByCodProcedencia", query = "SELECT m FROM MigraProductos m WHERE m.codProcedencia = :codProcedencia"),
    @NamedQuery(name = "MigraProductos.findNotArtiFamilia", query = "SELECT m FROM MigraProductos m WHERE m.articuloFamiliaId is null"),
    @NamedQuery(name = "MigraProductos.findByDescuentoProv", query = "SELECT m FROM MigraProductos m WHERE m.descuentoProv = :descuentoProv")})
public class MigraProductos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_num")
    private Integer codigoNum;
    @Size(max = 100)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 65)
    @Column(name = "cod_barra")
    private String codBarra;
    @Size(max = 150)
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_venta")
    private Double precioVenta;
    @Column(name = "precio_distribuidor")
    private Double precioDistribuidor;
    @Column(name = "precio_costo")
    private Double precioCosto;
    @Column(name = "porc_mostrador")
    private BigDecimal porcMostrador;
    @Column(name = "porc_distribuidor")
    private BigDecimal porcDistribuidor;
    @Column(name = "id_rubro")
    private Integer idRubro;
    @Column(name = "id_rubro1")
    private Integer idRubro1;
    @Column(name = "id_rubro2")
    private Integer idRubro2;
    @Column(name = "marca")
    private Integer marca;
    @Size(max = 65)
    @Column(name = "suspendido")
    private String suspendido;
    @Column(name = "tipo_impuesto")
    private Integer tipoImpuesto;
    @Column(name = "proveedor")
    private Integer proveedor;
    @Column(name = "calcular_stock")
    private Integer calcularStock;
    @Column(name = "stock_minimo")
    private Integer stockMinimo;
    @Column(name = "cod_medida")
    private Integer codMedida;
    @Column(name = "cod_procedencia")
    private Integer codProcedencia;
    @Column(name = "descuento_prov")
    private BigDecimal descuentoProv;
    @JoinColumn(name = "articulo_familia_id", referencedColumnName = "id")
    @ManyToOne
    private ArticulosFamilias articuloFamiliaId;
    
    
 

    public MigraProductos() {
    }

    public MigraProductos(Integer codigoNum) {
        this.codigoNum = codigoNum;
    }

    public Integer getCodigoNum() {
        return codigoNum;
    }

    public void setCodigoNum(Integer codigoNum) {
        this.codigoNum = codigoNum;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Double getPrecioDistribuidor() {
        return precioDistribuidor;
    }

    public void setPrecioDistribuidor(Double precioDistribuidor) {
        this.precioDistribuidor = precioDistribuidor;
    }

    public Double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(Double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public BigDecimal getPorcMostrador() {
        return porcMostrador;
    }

    public void setPorcMostrador(BigDecimal porcMostrador) {
        this.porcMostrador = porcMostrador;
    }

    public BigDecimal getPorcDistribuidor() {
        return porcDistribuidor;
    }

    public void setPorcDistribuidor(BigDecimal porcDistribuidor) {
        this.porcDistribuidor = porcDistribuidor;
    }

    public Integer getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(Integer idRubro) {
        this.idRubro = idRubro;
    }

    public Integer getIdRubro1() {
        return idRubro1;
    }

    public void setIdRubro1(Integer idRubro1) {
        this.idRubro1 = idRubro1;
    }

    public Integer getIdRubro2() {
        return idRubro2;
    }

    public void setIdRubro2(Integer idRubro2) {
        this.idRubro2 = idRubro2;
    }

    public Integer getMarca() {
        return marca;
    }

    public void setMarca(Integer marca) {
        this.marca = marca;
    }

    public String getSuspendido() {
        return suspendido;
    }

    public void setSuspendido(String suspendido) {
        this.suspendido = suspendido;
    }

    public Integer getTipoImpuesto() {
        return tipoImpuesto;
    }

    public void setTipoImpuesto(Integer tipoImpuesto) {
        this.tipoImpuesto = tipoImpuesto;
    }

    public Integer getProveedor() {
        return proveedor;
    }

    public void setProveedor(Integer proveedor) {
        this.proveedor = proveedor;
    }

    public Integer getCalcularStock() {
        return calcularStock;
    }

    public void setCalcularStock(Integer calcularStock) {
        this.calcularStock = calcularStock;
    }

    public Integer getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(Integer stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public Integer getCodMedida() {
        return codMedida;
    }

    public void setCodMedida(Integer codMedida) {
        this.codMedida = codMedida;
    }

    public Integer getCodProcedencia() {
        return codProcedencia;
    }

    public void setCodProcedencia(Integer codProcedencia) {
        this.codProcedencia = codProcedencia;
    }

    public BigDecimal getDescuentoProv() {
        return descuentoProv;
    }

    public void setDescuentoProv(BigDecimal descuentoProv) {
        this.descuentoProv = descuentoProv;
    }

    public ArticulosFamilias getArticuloFamiliaId() {
        return articuloFamiliaId;
    }

    public void setArticuloFamiliaId(ArticulosFamilias articuloFamiliaId) {
        this.articuloFamiliaId = articuloFamiliaId;
    }
    
    public String getArtiFamiDesc(){
    	if (this.articuloFamiliaId != null)
    		return this.articuloFamiliaId.getFamilia();
    	else return "";
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoNum != null ? codigoNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MigraProductos)) {
            return false;
        }
        MigraProductos other = (MigraProductos) object;
        if ((this.codigoNum == null && other.codigoNum != null) || (this.codigoNum != null && !this.codigoNum.equals(other.codigoNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.MigraProductos[ codigoNum=" + codigoNum + " ]";
    }

    
}
