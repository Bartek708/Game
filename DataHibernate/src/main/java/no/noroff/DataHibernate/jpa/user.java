package no.noroff.DataHibernate.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import no.noroff.DataHibernate.DataHibernateApplication;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class user implements Serializable {


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public ArrayList<chars> getCharacters(){
        ArrayList<chars> charsList = new ArrayList<>();

        for(chars chr : DataHibernateApplication.getCharacters()){

            if (getId() == chr.getUserID())
                charsList.add(chr);
        }

        return  charsList;
    }

    @Override
    public String toString() {
        return id + "\t" + username + "\t" + password;
    }

    @Id
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

}
