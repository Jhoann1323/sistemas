/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemas.controller;

import com.sistemas.ejb.TipoDiscoFacadeLocal;
import com.sistemas.model.TipoDisco;
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

@Named(value = "tipoDiscoSesion")
@SessionScoped
public class TipoDiscoSesion implements Serializable{
    
    @EJB 
    private TipoDiscoFacadeLocal tipoDiscoFacadeLocal ; 
    
    private TipoDisco tipoDisco  ; 
    
    private List<TipoDisco> tipoDiscos ; 
    
    private TipoDisco dis = new TipoDisco () ;
    private TipoDisco distemporal = new TipoDisco () ;
    
    
    
    @PostConstruct
    public void inir(){
        
        tipoDiscos = tipoDiscoFacadeLocal.findAll(); 
        
        tipoDisco = new TipoDisco();
        
    }
    
    public void registrarTipoDisco(){
        try {
            tipoDiscoFacadeLocal.create(dis);
            
            tipoDiscos= tipoDiscoFacadeLocal.findAll();
            
            dis = new TipoDisco () ;
            
        } catch (Exception e) {
        }
    }
    
    public void guardarTemporal (TipoDisco t){
        distemporal = t ; 
    }
    
    
    public void editarTipoDisco () {
        try {
            tipoDiscoFacadeLocal.edit(distemporal); 
            
            tipoDiscos= tipoDiscoFacadeLocal.findAll();
            
            distemporal = new TipoDisco () ; 
        } catch (Exception e) {
        }
    }
    public void eliminarTipoDisco (TipoDisco t){
        try {
            tipoDiscoFacadeLocal.remove(t);
            tipoDiscos= tipoDiscoFacadeLocal.findAll();
        } catch (Exception e) {
        }
    }

    public TipoDisco getTipoDisco() {
        return tipoDisco;
    }

    public void setTipoDisco(TipoDisco tipoDisco) {
        this.tipoDisco = tipoDisco;
    }

    public List<TipoDisco> getTipoDiscos() {
        return tipoDiscos;
    }

    public void setTipoDiscos(List<TipoDisco> tipoDiscos) {
        this.tipoDiscos = tipoDiscos;
    }

    public TipoDisco getDis() {
        return dis;
    }

    public void setDis(TipoDisco dis) {
        this.dis = dis;
    }

    public TipoDisco getDistemporal() {
        return distemporal;
    }

    public void setDistemporal(TipoDisco distemporal) {
        this.distemporal = distemporal;
    }
    
    
}
