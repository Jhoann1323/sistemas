/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sistemas.ejb;

import com.sistemas.model.TipoProcesador;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface TipoProcesadorFacadeLocal {

    void create(TipoProcesador tipoProcesador);

    void edit(TipoProcesador tipoProcesador);

    void remove(TipoProcesador tipoProcesador);

    TipoProcesador find(Object id);

    List<TipoProcesador> findAll();

    List<TipoProcesador> findRange(int[] range);

    int count();
    
}
