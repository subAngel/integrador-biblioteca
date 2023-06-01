/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controladores;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import logneg.lnbooks;
import modelo.Books;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Isra
 */
@Named(value = "cBooks")
@SessionScoped
public class cBooks implements Serializable {

    @EJB
    private lnbooks lnbooks;
    private Books book;

    public cBooks() {
        book = new Books();
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public List<Books> getBooks() {
        return lnbooks.findAll();
    }

    public void insertarlibro() {
        lnbooks.create(book);
    }

    public void buscarxID() {
        lnbooks.find(book);
    }

    public void submit() {
        if (book.getTitle() == null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El formulario no puede estar vacío");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return;
        } else {
            insertarlibro();
        }
        // Resto de la lógica de envío del formulario
    }
    
    public void eliminar (Books item){
     lnbooks.delete(item);
    }

    public void pruebainsert() {

        String titulo = book.getTitle();
        String autor = book.getAuthor();
        String editorial = book.getEdit();
        String paginas = book.getPages();
        String ejemplares = book.getEjemplares();
        int disponible = book.getAvailable();
        String fecha = book.getDate();
        String categoria = book.getCategory();
        String idioma = book.getLang();
        int stock = book.getStock();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        boolean ffecha = false;
        sdf.setLenient(false);
        try {
            sdf.parse(fecha);
            ffecha = true;
        } catch (ParseException e) {

        }

        //Validar titulo
        if (!titulo.matches("[A-Za-z ]+")) {
            mensaje("El campo titulo solo debe contener letras y espacios en blanco.");
        }
        if (!autor.matches("[A-Za-z ]+")) {
            mensaje("El campo autor solo debe contener letras y espacios en blanco.");
        }
        if (!editorial.matches("[A-Za-z ]+")) {
            mensaje("El campo editorial solo debe contener letras y espacios en blanco.");
        }

        if (!paginas.matches("^[1-9][0-9]*$") && Integer.parseInt(paginas) >= 49) {
            mensaje("El campo paginas solo debe contener un numero mayor o igual a 49 paginas.");

        }

        if (!ejemplares.matches("[A-Za-z ]+")) {
            mensaje("El campo ejemplares solo debe contener letras y espacios en blanco.");
        }

        if (disponible <= 0) {
            mensaje("El campo disponibles solo debe contener un numero mayor o igual a 1.");

        }
        if (!categoria.matches("[A-Za-z]+")) {
            mensaje("El campo categoria solo debe contener letras");
        }

        if (!idioma.matches("[A-Za-z]+")) {
            mensaje("El campo idioma solo debe contener letras");
        }
        if (stock<=0) {
            mensaje("El campo stock debe ser mayor a 0");
        } else {
            insertarlibro();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "El libro se agregó con éxito.", "");
            FacesContext.getCurrentInstance().addMessage("messages", message);
            PrimeFaces.current().ajax().update("myForm:myTable");
        }

    }

    public void mensaje(String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", detail);
        FacesContext.getCurrentInstance().addMessage("messages", message);
    }
}
