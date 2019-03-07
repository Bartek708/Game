package no.noroff.DataHibernate.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "abilities")
public class abilities implements Serializable {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return id + "\t" + ability + "\t" + description ;
    }

    @Id
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "ability", nullable = false)
    private String ability;

    @Column(name = "description", nullable = false)
    private String description;


}
