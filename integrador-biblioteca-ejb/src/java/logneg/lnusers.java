/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package logneg;

import accesodatos.UsersFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Users;

/**
 *
 * @author whoangel
 */
@Stateless
@LocalBean
public class lnusers {
@EJB
    private UsersFacade uf;

    public List<Users> findAll() {
        return uf.findAll();
    }

    public void create(Users u) {
        uf.create(u);
    }

    public void remove(Users u) {
        uf.remove(u);
    }

    public void edit(Users u) {
        uf.remove(u);
    }
}
