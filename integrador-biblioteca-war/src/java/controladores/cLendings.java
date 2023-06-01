/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controladores;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import logneg.lnlending;
import modelo.Lendings;

/**
 *
 * @author Isra
 */
@Named(value = "cLendings")
@SessionScoped
public class cLendings implements Serializable {

    @EJB
    private lnlending lnlending;
    private Lendings l;
    
      public cLendings() {
          l = new Lendings();
    }

    public Lendings getL() {
        return l;
    }

    public void setL(Lendings l) {
        this.l = l;
    }
    
    public List<Lendings> getLendings() {
    return lnlending.findAll();
    }
    
    public void insertarPrestamo(){
        lnlending.create(l);
    }
    
   


  
    
}
