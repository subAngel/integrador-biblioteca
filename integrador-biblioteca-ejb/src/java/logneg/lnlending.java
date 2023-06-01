/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package logneg;

import accesodatos.LendingsFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Lendings;

/**
 *
 * @author whoangel
 */
@Stateless
@LocalBean
public class lnlending {

    
    @EJB
    private LendingsFacade lf;
    
    public List<Lendings> findAll() {
     return lf.findAll();
    }
    
    public void create (Lendings l){
         lf.create(l);
    }
}
