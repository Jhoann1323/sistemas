/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemas.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juan
 */
@Entity
@Table(name = "tipo_disco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDisco.findAll", query = "SELECT t FROM TipoDisco t"),
    @NamedQuery(name = "TipoDisco.findByIdtipoDisco", query = "SELECT t FROM TipoDisco t WHERE t.idtipoDisco = :idtipoDisco"),
    @NamedQuery(name = "TipoDisco.findByTipoDisco", query = "SELECT t FROM TipoDisco t WHERE t.tipoDisco = :tipoDisco"),
    @NamedQuery(name = "TipoDisco.findByVelocidadLectura", query = "SELECT t FROM TipoDisco t WHERE t.velocidadLectura = :velocidadLectura")})
public class TipoDisco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo_disco")
    private Integer idtipoDisco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_disco")
    private String tipoDisco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "velocidad_lectura")
    private int velocidadLectura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDiscoIdtipoDisco", fetch = FetchType.LAZY)
    private List<Equipo> equipoList;

    public TipoDisco() {
    }

    public TipoDisco(Integer idtipoDisco) {
        this.idtipoDisco = idtipoDisco;
    }

    public TipoDisco(Integer idtipoDisco, String tipoDisco, int velocidadLectura) {
        this.idtipoDisco = idtipoDisco;
        this.tipoDisco = tipoDisco;
        this.velocidadLectura = velocidadLectura;
    }

    public Integer getIdtipoDisco() {
        return idtipoDisco;
    }

    public void setIdtipoDisco(Integer idtipoDisco) {
        this.idtipoDisco = idtipoDisco;
    }

    public String getTipoDisco() {
        return tipoDisco;
    }

    public void setTipoDisco(String tipoDisco) {
        this.tipoDisco = tipoDisco;
    }

    public int getVelocidadLectura() {
        return velocidadLectura;
    }

    public void setVelocidadLectura(int velocidadLectura) {
        this.velocidadLectura = velocidadLectura;
    }

    @XmlTransient
    public List<Equipo> getEquipoList() {
        return equipoList;
    }

    public void setEquipoList(List<Equipo> equipoList) {
        this.equipoList = equipoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoDisco != null ? idtipoDisco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDisco)) {
            return false;
        }
        TipoDisco other = (TipoDisco) object;
        if ((this.idtipoDisco == null && other.idtipoDisco != null) || (this.idtipoDisco != null && !this.idtipoDisco.equals(other.idtipoDisco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemas.model.TipoDisco[ idtipoDisco=" + idtipoDisco + " ]";
    }
    
}
