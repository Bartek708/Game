package no.noroff.DataHibernate.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "classabilities")
public class classabilities implements Serializable {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getAbilityID() {
        return abilityID;
    }

    public void setAbilityID(int abilityID) {
        this.abilityID = abilityID;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    @Override
    public String toString() {
        return id + "\t" + abilityID + "\t" + classID;
    }

    @Id
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "abilityID", nullable = false)
    private int abilityID;

    @Column(name = "classID", nullable = false)
    private int classID;

}
