/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 * @author admin
 */
@Entity
@Table(name = "equipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e"),
    @NamedQuery(name = "Equipo.findByIdequipo", query = "SELECT e FROM Equipo e WHERE e.idequipo = :idequipo"),
    @NamedQuery(name = "Equipo.findByNombreEquipo", query = "SELECT e FROM Equipo e WHERE e.nombreEquipo = :nombreEquipo")})
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
    @Column(name = "nombre_equipo")
    private String nombreEquipo;
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

    public Equipo(Integer idequipo, String nombreEquipo) {
        this.idequipo = idequipo;
        this.nombreEquipo = nombreEquipo;
    }

    public Integer getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(Integer idequipo) {
        this.idequipo = idequipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
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
