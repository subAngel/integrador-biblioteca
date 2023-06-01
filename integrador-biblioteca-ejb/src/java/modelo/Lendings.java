/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author whoangel
 */
@Entity
@Table(name = "lendings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lendings.findAll", query = "SELECT l FROM Lendings l"),
    @NamedQuery(name = "Lendings.findById", query = "SELECT l FROM Lendings l WHERE l.id = :id"),
    @NamedQuery(name = "Lendings.findByUserId", query = "SELECT l FROM Lendings l WHERE l.userId = :userId"),
    @NamedQuery(name = "Lendings.findByBookId", query = "SELECT l FROM Lendings l WHERE l.bookId = :bookId"),
    @NamedQuery(name = "Lendings.findByDateOut", query = "SELECT l FROM Lendings l WHERE l.dateOut = :dateOut"),
    @NamedQuery(name = "Lendings.findByDateReturn", query = "SELECT l FROM Lendings l WHERE l.dateReturn = :dateReturn")})
public class Lendings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "book_id")
    private int bookId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "date_out")
    private String dateOut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "date_return")
    private String dateReturn;

    public Lendings() {
    }

    public Lendings(Integer id) {
        this.id = id;
    }

    public Lendings(Integer id, int userId, int bookId, String dateOut, String dateReturn) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.dateOut = dateOut;
        this.dateReturn = dateReturn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public String getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(String dateReturn) {
        this.dateReturn = dateReturn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lendings)) {
            return false;
        }
        Lendings other = (Lendings) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Lendings[ id=" + id + " ]";
    }
    
}
