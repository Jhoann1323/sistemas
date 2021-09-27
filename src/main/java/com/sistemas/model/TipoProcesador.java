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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juan
 */
@Entity
@Table(name = "tipo_procesador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoProcesador.findAll", query = "SELECT t FROM TipoProcesador t"),
    @NamedQuery(name = "TipoProcesador.findByIdtipoprocesador", query = "SELECT t FROM TipoProcesador t WHERE t.idtipoprocesador = :idtipoprocesador"),
    @NamedQuery(name = "TipoProcesador.findByCantidadNucleos", query = "SELECT t FROM TipoProcesador t WHERE t.cantidadNucleos = :cantidadNucleos"),
    @NamedQuery(name = "TipoProcesador.findByCantidadHilos", query = "SELECT t FROM TipoProcesador t WHERE t.cantidadHilos = :cantidadHilos"),
    @NamedQuery(name = "TipoProcesador.findByFrecuenciaProcesador", query = "SELECT t FROM TipoProcesador t WHERE t.frecuenciaProcesador = :frecuenciaProcesador")})
public class TipoProcesador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipoprocesador")
    private Integer idtipoprocesador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_nucleos")
    private int cantidadNucleos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_hilos")
    private int cantidadHilos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "frecuencia_procesador")
    private int frecuenciaProcesador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoProcesadorIdtipoprocesador", fetch = FetchType.LAZY)
    private List<Equipo> equipoList;

    public TipoProcesador() {
    }

    public TipoProcesador(Integer idtipoprocesador) {
        this.idtipoprocesador = idtipoprocesador;
    }

    public TipoProcesador(Integer idtipoprocesador, int cantidadNucleos, int cantidadHilos, int frecuenciaProcesador) {
        this.idtipoprocesador = idtipoprocesador;
        this.cantidadNucleos = cantidadNucleos;
        this.cantidadHilos = cantidadHilos;
        this.frecuenciaProcesador = frecuenciaProcesador;
    }

    public Integer getIdtipoprocesador() {
        return idtipoprocesador;
    }

    public void setIdtipoprocesador(Integer idtipoprocesador) {
        this.idtipoprocesador = idtipoprocesador;
    }

    public int getCantidadNucleos() {
        return cantidadNucleos;
    }

    public void setCantidadNucleos(int cantidadNucleos) {
        this.cantidadNucleos = cantidadNucleos;
    }

    public int getCantidadHilos() {
        return cantidadHilos;
    }

    public void setCantidadHilos(int cantidadHilos) {
        this.cantidadHilos = cantidadHilos;
    }

    public int getFrecuenciaProcesador() {
        return frecuenciaProcesador;
    }

    public void setFrecuenciaProcesador(int frecuenciaProcesador) {
        this.frecuenciaProcesador = frecuenciaProcesador;
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
        hash += (idtipoprocesador != null ? idtipoprocesador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProcesador)) {
            return false;
        }
        TipoProcesador other = (TipoProcesador) object;
        if ((this.idtipoprocesador == null && other.idtipoprocesador != null) || (this.idtipoprocesador != null && !this.idtipoprocesador.equals(other.idtipoprocesador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemas.model.TipoProcesador[ idtipoprocesador=" + idtipoprocesador + " ]";
    }
    
}
