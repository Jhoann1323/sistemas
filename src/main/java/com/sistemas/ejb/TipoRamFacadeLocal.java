/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sistemas.ejb;

import com.sistemas.model.TipoRam;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface TipoRamFacadeLocal {

    void create(TipoRam tipoRam);

    void edit(TipoRam tipoRam);

    void remove(TipoRam tipoRam);

    TipoRam find(Object id);

    List<TipoRam> findAll();

    List<TipoRam> findRange(int[] range);

    int count();
    
}
