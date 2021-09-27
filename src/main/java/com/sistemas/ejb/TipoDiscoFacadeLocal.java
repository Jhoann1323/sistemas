/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sistemas.ejb;

import com.sistemas.model.TipoDisco;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface TipoDiscoFacadeLocal {

    void create(TipoDisco tipoDisco);

    void edit(TipoDisco tipoDisco);

    void remove(TipoDisco tipoDisco);

    TipoDisco find(Object id);

    List<TipoDisco> findAll();

    List<TipoDisco> findRange(int[] range);

    int count();
    
}
