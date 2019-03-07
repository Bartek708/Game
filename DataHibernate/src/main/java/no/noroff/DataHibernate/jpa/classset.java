package no.noroff.DataHibernate.jpa;


        import no.noroff.DataHibernate.DataHibernateApplication;

        import java.io.Serializable;
        import java.util.ArrayList;
        import javax.persistence.*;


@Entity
@Table(name = "classset")
public class classset implements Serializable {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Transient
    public ArrayList<abilities> getAbilities(){
        ArrayList<abilities> abilityList = new ArrayList<>();

        for(abilities ability : DataHibernateApplication.getAbilities()){
            for(classabilities classAbility : DataHibernateApplication.getClassAbilities()) {
                if (getId() == classAbility.getClassID() && classAbility.getAbilityID() == ability.getId())
                    abilityList.add(ability);
            }
        }
        return  abilityList;
    }

    @Override
    public String toString() {
        return id + "\t" + name;
    }

    @Id
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "className", nullable = false)
    private String name;



}
