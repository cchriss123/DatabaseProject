package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mainCounty", schema = "landskapsquiz", catalog = "")
@NamedQuery(query = "SELECT c FROM MainCountyEntity c", name = "showCounty")
public class MainCountyEntity extends CRUD.Entity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "mainCountyId")
    private int mainCountyId;
    @Basic
    @Column(name = "mainCountyName")
    private String mainCountyName;

    public int getMainCountyId() {
        return mainCountyId;
    }

    public void setMainCountyId(int mainCountyId) {
        this.mainCountyId = mainCountyId;
    }

    public String getMainCountyName() {
        return mainCountyName;
    }

    public void setMainCountyName(String mainCountyName) {
        this.mainCountyName = mainCountyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MainCountyEntity county = (MainCountyEntity) o;

        if (mainCountyId != county.mainCountyId) return false;
        if (mainCountyName != null ? !mainCountyName.equals(county.mainCountyName) : county.mainCountyName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mainCountyId;
        result = 31 * result + (mainCountyName != null ? mainCountyName.hashCode() : 0);
        return result;
    }
}
