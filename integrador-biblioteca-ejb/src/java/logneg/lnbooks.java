/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package logneg;

import accesodatos.BooksFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Books;

/**
 *
 * @author whoangel
 */
@Stateless
@LocalBean
public class lnbooks {
@EJB
    private BooksFacade bf;

    public List<Books> findAll() {
     return bf.findAll();
    }
    
    public void create(Books b){
        bf.create(b);
    }
    
    public void find(Books entity){
        bf.edit(entity);
    }
    public void delete(Books d){
        bf.remove(d);
    }
}
