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
import logneg.lnusers;
import modelo.Users;

/**
 *
 * @author Isra
 */
@Named(value = "cUsers")
@SessionScoped
public class cUsers implements Serializable {

    @EJB
    private lnusers lnusers;
    private Users user;

    public cUsers() {
        user = new Users();
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<Users> getUsers() {
        return lnusers.findAll();
    }

    public void insertUser() {
        lnusers.create(user);

    }

    public void removeUser(Users item) {
        lnusers.remove(item);

    }

    public void editUser() {
        lnusers.edit(user);

    }

}
