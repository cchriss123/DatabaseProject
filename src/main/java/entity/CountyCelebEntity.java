package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "countyCeleb", schema = "landskapsquiz", catalog = "")

public class CountyCelebEntity extends CRUD.Entity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "countyCelebId")
    private int countyCelebId;
    @Basic
    @Column(name = "countyCelebName")
    private String countyCelebName;
    @Basic
    @Column(name = "countyCelebAge")
    private Integer countyCelebAge;
    @Basic
    @Column(name = "mainCountyCeleb")
    private Integer mainCountyCeleb;

    public int getCountyCelebId() {
        return countyCelebId;
    }

    public void setCountyCelebId(int countyCelebId) {
        this.countyCelebId = countyCelebId;
    }

    public String getCountyCelebName() {
        return countyCelebName;
    }

    public void setCountyCelebName(String countyCelebName) {
        this.countyCelebName = countyCelebName;
    }

    public Integer getCountyCelebAge() {
        return countyCelebAge;
    }

    public void setCountyCelebAge(Integer countyCelebAge) {
        this.countyCelebAge = countyCelebAge;
    }

    public Integer getMainCountyCeleb() {
        return mainCountyCeleb;
    }

    public void setMainCountyCeleb(Integer mainCountyCeleb) {
        this.mainCountyCeleb = mainCountyCeleb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountyCelebEntity that = (CountyCelebEntity) o;

        if (countyCelebId != that.countyCelebId) return false;
        if (countyCelebName != null ? !countyCelebName.equals(that.countyCelebName) : that.countyCelebName != null)
            return false;
        if (countyCelebAge != null ? !countyCelebAge.equals(that.countyCelebAge) : that.countyCelebAge != null)
            return false;
        if (mainCountyCeleb != null ? !mainCountyCeleb.equals(that.mainCountyCeleb) : that.mainCountyCeleb != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = countyCelebId;
        result = 31 * result + (countyCelebName != null ? countyCelebName.hashCode() : 0);
        result = 31 * result + (countyCelebAge != null ? countyCelebAge.hashCode() : 0);
        result = 31 * result + (mainCountyCeleb != null ? mainCountyCeleb.hashCode() : 0);
        return result;
    }
}
