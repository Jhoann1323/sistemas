/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemas.controller;

import com.sistemas.ejb.EquipoFacadeLocal;
import com.sistemas.ejb.TipoDiscoFacadeLocal;
import com.sistemas.ejb.TipoProcesadorFacadeLocal;
import com.sistemas.ejb.TipoRamFacadeLocal;
import com.sistemas.model.Equipo;
import com.sistemas.model.TipoDisco;
import com.sistemas.model.TipoProcesador;
import com.sistemas.model.TipoRam;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author admin
 */
@Named(value = "equipoSesion")
@SessionScoped
public class EquipoSesion implements Serializable {
    
    @EJB 
    private EquipoFacadeLocal equipoFacadeLocal ; 
    //Estructura para las llaves foraneas//
    @EJB 
    private TipoProcesadorFacadeLocal tipoProcesadorFacadeLocal   ;
    @EJB 
    private TipoRamFacadeLocal tipoRamFacadeLocal  ;
    @EJB 
    private TipoDiscoFacadeLocal tipoDiscoFacadeLocal ;
  
    private Equipo equipo ; 
    // inyeccion de dependencias (llaves foraneas) 
    @Inject
    private TipoProcesador tipoProcesador ; 
    @Inject
    private TipoRam tipoRam ; 
    @Inject 
    private TipoDisco tipoDisco ; 
    
    private List<Equipo> equipos ; 
    
    //Estructura para listas de llaves foraneas (inyeccion de dependecias)
    private List<TipoProcesador> tipoProcesadores ;
    private List<TipoRam> tipoRams; 
    private List<TipoDisco> tipoDiscos; 
    
    private Equipo eq = new Equipo () ;
    private Equipo eqreg = new Equipo() ;
    private Equipo eqtemporal = new Equipo () ;
    
    
    
    @PostConstruct
    public void init(){
        //ESTRUCTURA PARA RENDERIZADO DE LLAVES FORANEAS
        tipoProcesadores=tipoProcesadorFacadeLocal.findAll(); 
        tipoRams=tipoRamFacadeLocal.findAll(); 
        tipoDiscos=tipoDiscoFacadeLocal.findAll();
        equipos=equipoFacadeLocal.findAll(); 
        equipo=new Equipo() ; 
        
    }
    public void registrarEquipo(){
        try {
            
            eqreg.setTipoProcesadorIdtipoprocesador(tipoProcesador);
            eqreg.setTipoRamIdtipoRam(tipoRam);
            eqreg.setTipoDiscoIdtipoDisco(tipoDisco);
            equipoFacadeLocal.create(eqreg); 
            
            tipoProcesador = new TipoProcesador() ;
            tipoRam = new TipoRam () ;
            tipoDisco = new TipoDisco () ;
            eqreg = new Equipo() ;
            equipos=equipoFacadeLocal.findAll(); 
        } catch (Exception e) {
        }
    }
    
    public void guardarTemporal (Equipo t){
        eqtemporal = t ;
        
    }
    
    public void editarRquipo (){
        try {
            eqtemporal.setTipoProcesadorIdtipoprocesador(tipoProcesador);
            eqtemporal.setTipoRamIdtipoRam(tipoRam);
            eqtemporal.setTipoDiscoIdtipoDisco(tipoDisco);
            equipoFacadeLocal.edit(eqtemporal);
            
            eqtemporal =new Equipo () ;
            tipoProcesador = new TipoProcesador() ;
            tipoRam = new TipoRam () ;
            tipoDisco = new TipoDisco () ;
            equipos=equipoFacadeLocal.findAll(); 
        } catch (Exception e) {
        }
    }
    public void eliminarEquipo (Equipo t){
        try {
            equipoFacadeLocal.remove(t);
            equipos=equipoFacadeLocal.findAll(); 
        } catch (Exception e) {
        }
    }
    
    

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

 

    public Equipo getEqtemporal() {
        return eqtemporal;
    }

    public void setEqtemporal(Equipo eqtemporal) {
        this.eqtemporal = eqtemporal;
    }

    public EquipoFacadeLocal getEquipoFacadeLocal() {
        return equipoFacadeLocal;
    }

    public void setEquipoFacadeLocal(EquipoFacadeLocal equipoFacadeLocal) {
        this.equipoFacadeLocal = equipoFacadeLocal;
    }

    public TipoProcesador getTipoProcesador() {
        return tipoProcesador;
    }

    public void setTipoProcesador(TipoProcesador tipoProcesador) {
        this.tipoProcesador = tipoProcesador;
    }

    public TipoRam getTipoRam() {
        return tipoRam;
    }

    public void setTipoRam(TipoRam tipoRam) {
        this.tipoRam = tipoRam;
    }

    public TipoDisco getTipoDisco() {
        return tipoDisco;
    }

    public void setTipoDisco(TipoDisco tipoDisco) {
        this.tipoDisco = tipoDisco;
    }

    public List<TipoProcesador> getTipoProcesadores() {
        return tipoProcesadores;
    }

    public void setTipoProcesadores(List<TipoProcesador> tipoProcesadores) {
        this.tipoProcesadores = tipoProcesadores;
    }

    public List<TipoRam> getTipoRams() {
        return tipoRams;
    }

    public void setTipoRams(List<TipoRam> tipoRams) {
        this.tipoRams = tipoRams;
    }

    public List<TipoDisco> getTipoDiscos() {
        return tipoDiscos;
    }

    public void setTipoDiscos(List<TipoDisco> tipoDiscos) {
        this.tipoDiscos = tipoDiscos;
    }

    public Equipo getEq() {
        return eq;
    }

    public void setEq(Equipo eq) {
        this.eq = eq;
    }

    public Equipo getEqreg() {
        return eqreg;
    }

    public void setEqreg(Equipo eqreg) {
        this.eqreg = eqreg;
    }
    
}
