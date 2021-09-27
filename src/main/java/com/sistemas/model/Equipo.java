/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemas.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juan
 */
@Entity
@Table(name = "equipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e"),
    @NamedQuery(name = "Equipo.findByIdequipo", query = "SELECT e FROM Equipo e WHERE e.idequipo = :idequipo"),
    @NamedQuery(name = "Equipo.findByNombreProcesador", query = "SELECT e FROM Equipo e WHERE e.nombreProcesador = :nombreProcesador"),
    @NamedQuery(name = "Equipo.findByNombreRam", query = "SELECT e FROM Equipo e WHERE e.nombreRam = :nombreRam"),
    @NamedQuery(name = "Equipo.findByNombreDisco", query = "SELECT e FROM Equipo e WHERE e.nombreDisco = :nombreDisco")})
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idequipo")
    private Integer idequipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_procesador")
    private String nombreProcesador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_ram")
    private String nombreRam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_disco")
    private String nombreDisco;
    @JoinColumn(name = "tipo_disco_idtipo_disco", referencedColumnName = "idtipo_disco")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoDisco tipoDiscoIdtipoDisco;
    @JoinColumn(name = "tipo_procesador_idtipoprocesador", referencedColumnName = "idtipoprocesador")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoProcesador tipoProcesadorIdtipoprocesador;
    @JoinColumn(name = "tipo_ram_idtipo_ram", referencedColumnName = "idtipo_ram")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoRam tipoRamIdtipoRam;

    public Equipo() {
    }

    public Equipo(Integer idequipo) {
        this.idequipo = idequipo;
    }

    public Equipo(Integer idequipo, String nombreProcesador, String nombreRam, String nombreDisco) {
        this.idequipo = idequipo;
        this.nombreProcesador = nombreProcesador;
        this.nombreRam = nombreRam;
        this.nombreDisco = nombreDisco;
    }

    public Integer getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(Integer idequipo) {
        this.idequipo = idequipo;
    }

    public String getNombreProcesador() {
        return nombreProcesador;
    }

    public void setNombreProcesador(String nombreProcesador) {
        this.nombreProcesador = nombreProcesador;
    }

    public String getNombreRam() {
        return nombreRam;
    }

    public void setNombreRam(String nombreRam) {
        this.nombreRam = nombreRam;
    }

    public String getNombreDisco() {
        return nombreDisco;
    }

    public void setNombreDisco(String nombreDisco) {
        this.nombreDisco = nombreDisco;
    }

    public TipoDisco getTipoDiscoIdtipoDisco() {
        return tipoDiscoIdtipoDisco;
    }

    public void setTipoDiscoIdtipoDisco(TipoDisco tipoDiscoIdtipoDisco) {
        this.tipoDiscoIdtipoDisco = tipoDiscoIdtipoDisco;
    }

    public TipoProcesador getTipoProcesadorIdtipoprocesador() {
        return tipoProcesadorIdtipoprocesador;
    }

    public void setTipoProcesadorIdtipoprocesador(TipoProcesador tipoProcesadorIdtipoprocesador) {
        this.tipoProcesadorIdtipoprocesador = tipoProcesadorIdtipoprocesador;
    }

    public TipoRam getTipoRamIdtipoRam() {
        return tipoRamIdtipoRam;
    }

    public void setTipoRamIdtipoRam(TipoRam tipoRamIdtipoRam) {
        this.tipoRamIdtipoRam = tipoRamIdtipoRam;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idequipo != null ? idequipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.idequipo == null && other.idequipo != null) || (this.idequipo != null && !this.idequipo.equals(other.idequipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemas.model.Equipo[ idequipo=" + idequipo + " ]";
    }
    
}
