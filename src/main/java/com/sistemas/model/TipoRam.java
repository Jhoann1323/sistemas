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
@Table(name = "tipo_ram")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoRam.findAll", query = "SELECT t FROM TipoRam t"),
    @NamedQuery(name = "TipoRam.findByIdtipoRam", query = "SELECT t FROM TipoRam t WHERE t.idtipoRam = :idtipoRam"),
    @NamedQuery(name = "TipoRam.findByCapacidad", query = "SELECT t FROM TipoRam t WHERE t.capacidad = :capacidad"),
    @NamedQuery(name = "TipoRam.findByFrecuenciaRam", query = "SELECT t FROM TipoRam t WHERE t.frecuenciaRam = :frecuenciaRam"),
    @NamedQuery(name = "TipoRam.findByTipoDDR", query = "SELECT t FROM TipoRam t WHERE t.tipoDDR = :tipoDDR")})
public class TipoRam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo_ram")
    private Integer idtipoRam;
    @Basic(optional = false)
    @NotNull
    @Column(name = "capacidad")
    private int capacidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "frecuencia_ram")
    private int frecuenciaRam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "tipo DDR")
    private String tipoDDR;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoRamIdtipoRam", fetch = FetchType.LAZY)
    private List<Equipo> equipoList;

    public TipoRam() {
    }

    public TipoRam(Integer idtipoRam) {
        this.idtipoRam = idtipoRam;
    }

    public TipoRam(Integer idtipoRam, int capacidad, int frecuenciaRam, String tipoDDR) {
        this.idtipoRam = idtipoRam;
        this.capacidad = capacidad;
        this.frecuenciaRam = frecuenciaRam;
        this.tipoDDR = tipoDDR;
    }

    public Integer getIdtipoRam() {
        return idtipoRam;
    }

    public void setIdtipoRam(Integer idtipoRam) {
        this.idtipoRam = idtipoRam;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getFrecuenciaRam() {
        return frecuenciaRam;
    }

    public void setFrecuenciaRam(int frecuenciaRam) {
        this.frecuenciaRam = frecuenciaRam;
    }

    public String getTipoDDR() {
        return tipoDDR;
    }

    public void setTipoDDR(String tipoDDR) {
        this.tipoDDR = tipoDDR;
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
        hash += (idtipoRam != null ? idtipoRam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoRam)) {
            return false;
        }
        TipoRam other = (TipoRam) object;
        if ((this.idtipoRam == null && other.idtipoRam != null) || (this.idtipoRam != null && !this.idtipoRam.equals(other.idtipoRam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemas.model.TipoRam[ idtipoRam=" + idtipoRam + " ]";
    }
    
}
