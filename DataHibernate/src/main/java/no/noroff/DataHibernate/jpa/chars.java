package no.noroff.DataHibernate.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import no.noroff.DataHibernate.DataHibernateApplication;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name = "chars")
public class chars implements Serializable {


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getUserID() {
        return userID;
    }


    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }


    @Transient
    public ArrayList<classset> getClasses(){
        ArrayList<classset> classList = new ArrayList<>();

        for(classset clas : DataHibernateApplication.getClasses()){

            if (Integer.parseInt(getClassID()) == clas.getId())
                classList.add(clas);
             }

        return  classList;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + level;
    }


    @Id
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "level", nullable = false)
    private int level;

    @Column(name = "userID", nullable = false)
    private int userID;

    @Column(name = "classID", nullable = false)
    private String classID;



}
