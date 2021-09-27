/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemas.controller;

import com.sistemas.ejb.TipoProcesadorFacadeLocal;
import com.sistemas.model.TipoProcesador;
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
@Named(value = "tipoProcesadorSesion")
@SessionScoped
public class TipoProcesadorSesion implements Serializable{
    //Es el punto de conexion con la base de datos// 
    @EJB
    private TipoProcesadorFacadeLocal tipoProcesadorFacadeLocal; 
    
    private TipoProcesador tipoProcesador; 
    //Lista de objetos //
    private List<TipoProcesador> tipoProcesadores ; 
    //Instancias de sesion//
    private TipoProcesador pro = new TipoProcesador ();
    private TipoProcesador protemporal = new TipoProcesador ();
    
    //Carga inicial//
    @PostConstruct 
    public void init() {
        //Obtener objetos de la base de datos (render) //
        tipoProcesadores=tipoProcesadorFacadeLocal.findAll();
        
        tipoProcesador=new TipoProcesador(); 
        
        
    }
   
    public void registrarTipoProcesador(){
        try {
            tipoProcesadorFacadeLocal.create(pro);
            //Renderizado de la tabla //
            tipoProcesadores=tipoProcesadorFacadeLocal.findAll(); 
            //limpieza de objeto //
            pro = new TipoProcesador() ;
        } catch (Exception e) {
        }
    }
    //guardado temporal// 
       public void guardarTemporal(TipoProcesador t){
           protemporal = t ; 
           
       }
       
       public void editarTipoProcesador () {
           try {
               tipoProcesadorFacadeLocal.edit(protemporal);
               tipoProcesadores=tipoProcesadorFacadeLocal.findAll(); 
               protemporal = new TipoProcesador () ; 
           } catch (Exception e) {
           }
       }
       public void eliminarTipoProcesador (TipoProcesador t ){
           try {
               tipoProcesadorFacadeLocal.remove(t);
               tipoProcesadores=tipoProcesadorFacadeLocal.findAll(); 
               
           } catch (Exception e) {
           }
       }

    public TipoProcesador getTipoProcesador() {
        return tipoProcesador;
    }

    public void setTipoProcesador(TipoProcesador tipoProcesador) {
        this.tipoProcesador = tipoProcesador;
    }

    public List<TipoProcesador> getTipoProcesadores() {
        return tipoProcesadores;
    }

    public void setTipoProcesadores(List<TipoProcesador> tipoProcesadores) {
        this.tipoProcesadores = tipoProcesadores;
    }

    public TipoProcesador getPro() {
        return pro;
    }

    public void setPro(TipoProcesador pro) {
        this.pro = pro;
    }

    public TipoProcesador getProtemporal() {
        return protemporal;
    }

    public void setProtemporal(TipoProcesador protemporal) {
        this.protemporal = protemporal;
    }
       
      
}
