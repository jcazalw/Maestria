/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package foo.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jcazalw
 */
@Entity
@Table(name = "personas_migra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonasMigra.findAll", query = "SELECT p FROM PersonasMigra p"),
    @NamedQuery(name = "PersonasMigra.findById", query = "SELECT p FROM PersonasMigra p WHERE p.id = :id"),
    @NamedQuery(name = "PersonasMigra.findByPersonaTipoId", query = "SELECT p FROM PersonasMigra p WHERE p.personaTipoId = :personaTipoId"),
    @NamedQuery(name = "PersonasMigra.findByNombres", query = "SELECT p FROM PersonasMigra p WHERE p.nombres = :nombres"),
    @NamedQuery(name = "PersonasMigra.findByApellidos", query = "SELECT p FROM PersonasMigra p WHERE p.apellidos = :apellidos"),
    @NamedQuery(name = "PersonasMigra.findByDenominacion", query = "SELECT p FROM PersonasMigra p WHERE p.denominacion = :denominacion"),
    @NamedQuery(name = "PersonasMigra.findByRutaImagen", query = "SELECT p FROM PersonasMigra p WHERE p.rutaImagen = :rutaImagen"),
    @NamedQuery(name = "PersonasMigra.findByDocumentoTipoId", query = "SELECT p FROM PersonasMigra p WHERE p.documentoTipoId = :documentoTipoId"),
    @NamedQuery(name = "PersonasMigra.findByNumeroDocumento", query = "SELECT p FROM PersonasMigra p WHERE p.numeroDocumento = :numeroDocumento"),
    @NamedQuery(name = "PersonasMigra.findBySexo", query = "SELECT p FROM PersonasMigra p WHERE p.sexo = :sexo"),
    @NamedQuery(name = "PersonasMigra.findByFechaNacimiento", query = "SELECT p FROM PersonasMigra p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "PersonasMigra.findByDireccion", query = "SELECT p FROM PersonasMigra p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "PersonasMigra.findByTelefono", query = "SELECT p FROM PersonasMigra p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "PersonasMigra.findByMail", query = "SELECT p FROM PersonasMigra p WHERE p.mail = :mail"),
    @NamedQuery(name = "PersonasMigra.findByCategoriaId", query = "SELECT p FROM PersonasMigra p WHERE p.categoriaId = :categoriaId"),
    @NamedQuery(name = "PersonasMigra.findByPaisId", query = "SELECT p FROM PersonasMigra p WHERE p.paisId = :paisId"),
    @NamedQuery(name = "PersonasMigra.findByDepartamentoId", query = "SELECT p FROM PersonasMigra p WHERE p.departamentoId = :departamentoId"),
    @NamedQuery(name = "PersonasMigra.findByCiudadId", query = "SELECT p FROM PersonasMigra p WHERE p.ciudadId = :ciudadId"),
    @NamedQuery(name = "PersonasMigra.findByFiliadoId", query = "SELECT p FROM PersonasMigra p WHERE p.filiadoId = :filiadoId"),
    @NamedQuery(name = "PersonasMigra.findByFechaIngreso", query = "SELECT p FROM PersonasMigra p WHERE p.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "PersonasMigra.findByEstado", query = "SELECT p FROM PersonasMigra p WHERE p.estado = :estado")})
public class PersonasMigra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "persona_tipo_id")
    private Short personaTipoId;
    @Size(max = 64)
    @Column(name = "nombres")
    private String nombres;
    @Size(max = 64)
    @Column(name = "apellidos")
    private String apellidos;
    @Size(max = 128)
    @Column(name = "denominacion")
    private String denominacion;
    @Size(max = 128)
    @Column(name = "ruta_imagen")
    private String rutaImagen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "documento_tipo_id")
    private short documentoTipoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numero_documento")
    private String numeroDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sexo")
    private short sexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 128)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 60)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 64)
    @Column(name = "mail")
    private String mail;
    @Column(name = "categoria_id")
    private Short categoriaId;
    @Column(name = "pais_id")
    private Short paisId;
    @Column(name = "departamento_id")
    private Short departamentoId;
    @Column(name = "ciudad_id")
    private Short ciudadId;
    @Column(name = "filiado_id")
    private Integer filiadoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private short estado;

    public PersonasMigra() {
    }

    public PersonasMigra(Integer id) {
        this.id = id;
    }

    public PersonasMigra(Integer id, short documentoTipoId, String numeroDocumento, short sexo, Date fechaNacimiento, Date fechaIngreso, short estado) {
        this.id = id;
        this.documentoTipoId = documentoTipoId;
        this.numeroDocumento = numeroDocumento;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getPersonaTipoId() {
        return personaTipoId;
    }

    public void setPersonaTipoId(Short personaTipoId) {
        this.personaTipoId = personaTipoId;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public short getDocumentoTipoId() {
        return documentoTipoId;
    }

    public void setDocumentoTipoId(short documentoTipoId) {
        this.documentoTipoId = documentoTipoId;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public short getSexo() {
        return sexo;
    }

    public void setSexo(short sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Short getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Short categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Short getPaisId() {
        return paisId;
    }

    public void setPaisId(Short paisId) {
        this.paisId = paisId;
    }

    public Short getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Short departamentoId) {
        this.departamentoId = departamentoId;
    }

    public Short getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(Short ciudadId) {
        this.ciudadId = ciudadId;
    }

    public Integer getFiliadoId() {
        return filiadoId;
    }

    public void setFiliadoId(Integer filiadoId) {
        this.filiadoId = filiadoId;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
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
        if (!(object instanceof PersonasMigra)) {
            return false;
        }
        PersonasMigra other = (PersonasMigra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.PersonasMigra[ id=" + id + " ]";
    }
    
}
