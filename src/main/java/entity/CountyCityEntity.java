package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "countyCity", schema = "landskapsquiz", catalog = "")
public class CountyCityEntity extends CRUD.Entity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "countyCityId")
    private int countyCityId;
    @Basic
    @Column(name = "countyCityName")
    private String countyCityName;
    @Basic
    @Column(name = "countyCityPopulation")
    private Integer countyCityPopulation;
    @Basic
    @Column(name = "mainCountyCity")
    private Integer mainCountyCity;

    public int getCountyCityId() {
        return countyCityId;
    }

    public void setCountyCityId(int countyCityId) {
        this.countyCityId = countyCityId;
    }

    public String getCountyCityName() {
        return countyCityName;
    }

    public void setCountyCityName(String countyCityName) {
        this.countyCityName = countyCityName;
    }

    public Integer getCountyCityPopulation() {
        return countyCityPopulation;
    }

    public void setCountyCityPopulation(Integer countyCityPopulation) {
        this.countyCityPopulation = countyCityPopulation;
    }

    public Integer getMainCountyCity() {
        return mainCountyCity;
    }

    public void setMainCountyCity(Integer mainCountyCity) {
        this.mainCountyCity = mainCountyCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountyCityEntity that = (CountyCityEntity) o;

        if (countyCityId != that.countyCityId) return false;
        if (countyCityName != null ? !countyCityName.equals(that.countyCityName) : that.countyCityName != null)
            return false;
        if (countyCityPopulation != null ? !countyCityPopulation.equals(that.countyCityPopulation) : that.countyCityPopulation != null)
            return false;
        if (mainCountyCity != null ? !mainCountyCity.equals(that.mainCountyCity) : that.mainCountyCity != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = countyCityId;
        result = 31 * result + (countyCityName != null ? countyCityName.hashCode() : 0);
        result = 31 * result + (countyCityPopulation != null ? countyCityPopulation.hashCode() : 0);
        result = 31 * result + (mainCountyCity != null ? mainCountyCity.hashCode() : 0);
        return result;
    }
}
