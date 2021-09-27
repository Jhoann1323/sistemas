/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemas.controller;

import com.sistemas.ejb.TipoRamFacadeLocal;
import com.sistemas.model.TipoRam;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author admin
 */
@Named(value = "tipoRamSesion")
@SessionScoped
public class TipoRamSesion implements Serializable {

    @EJB
    private TipoRamFacadeLocal tipoRamFacadeLocal;

    private TipoRam tipoRam;

    private List<TipoRam> tipoRams;

    private TipoRam ram = new TipoRam();
    private TipoRam ramtemporal = new TipoRam();

    @PostConstruct
    public void init() {
        tipoRams = tipoRamFacadeLocal.findAll();

        tipoRam = new TipoRam();

    }

    public void registrarTipoRam() {
        try {
            tipoRamFacadeLocal.create(ram);

            tipoRams = tipoRamFacadeLocal.findAll();

            ram = new TipoRam();
        } catch (Exception e) {
        }
    }

    public void guardarTemporal(TipoRam t) {
        ramtemporal = t;
    }

    public void editarTipoRam() {
        try {
            tipoRamFacadeLocal.edit(ramtemporal);
            tipoRams = tipoRamFacadeLocal.findAll();
            ramtemporal = new TipoRam();

        } catch (Exception e) {
        }
            
    }
    
    public void eliminarTipoRam (TipoRam t){
        try {
            tipoRamFacadeLocal.remove(t);
            tipoRams = tipoRamFacadeLocal.findAll();
        } catch (Exception e) {
        }
    }

    public TipoRam getTipoRam() {
        return tipoRam;
    }

    public void setTipoRam(TipoRam tipoRam) {
        this.tipoRam = tipoRam;
    }

    public List<TipoRam> getTipoRams() {
        return tipoRams;
    }

    public void setTipoRams(List<TipoRam> tipoRams) {
        this.tipoRams = tipoRams;
    }

    public TipoRam getRam() {
        return ram;
    }

    public void setRam(TipoRam ram) {
        this.ram = ram;
    }

    public TipoRam getRamtemporal() {
        return ramtemporal;
    }

    public void setProtemporal(TipoRam ramtemporal) {
        this.ramtemporal = ramtemporal;
    }



   
}
