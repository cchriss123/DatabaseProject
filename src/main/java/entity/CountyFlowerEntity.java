package entity;

import jakarta.persistence.*;

@Entity
//@NamedQuery(query = "SELECT b from BokEntity b WHERE b.bokForfattare = :forfattare", name = "bokForfattareQuery")
//@NamedQuery(query = "SELECT b from BokEntity b", name = "bokQuery")
//@NamedQuery(query = "SELECT f from CountyFlowerEntity f", name = "flowerQuery")
@Table(name = "countyFlower", schema = "landskapsquiz", catalog = "")
public class CountyFlowerEntity extends CRUD.Entity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "countyFlowerId")
    private int countyFlowerId;
    @Basic
    @Column(name = "countyFlowerName")
    private String countyFlowerName;
    @Basic
    @Column(name = "countyFlowerColor")
    private String countyFlowerColor;
    @Basic
    @Column(name = "mainCountyFlowerId")
    private Integer mainCountyFlowerId;

    public int getCountyFlowerId() {
        return countyFlowerId;
    }

    public void setCountyFlowerId(int countyFlowerId) {
        this.countyFlowerId = countyFlowerId;
    }

    public String getCountyFlowerName() {
        return countyFlowerName;
    }

    public void setCountyFlowerName(String countyFlowerName) {
        this.countyFlowerName = countyFlowerName;
    }

    public String getCountyFlowerColor() {
        return countyFlowerColor;
    }

    public void setCountyFlowerColor(String countyFlowerColor) {
        this.countyFlowerColor = countyFlowerColor;
    }

    public Integer getMainCountyFlowerId() {
        return mainCountyFlowerId;
    }

    public void setMainCountyFlowerId(Integer mainCountyFlowerId) {
        this.mainCountyFlowerId = mainCountyFlowerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountyFlowerEntity that = (CountyFlowerEntity) o;

        if (countyFlowerId != that.countyFlowerId) return false;
        if (countyFlowerName != null ? !countyFlowerName.equals(that.countyFlowerName) : that.countyFlowerName != null)
            return false;
        if (countyFlowerColor != null ? !countyFlowerColor.equals(that.countyFlowerColor) : that.countyFlowerColor != null)
            return false;
        if (mainCountyFlowerId != null ? !mainCountyFlowerId.equals(that.mainCountyFlowerId) : that.mainCountyFlowerId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = countyFlowerId;
        result = 31 * result + (countyFlowerName != null ? countyFlowerName.hashCode() : 0);
        result = 31 * result + (countyFlowerColor != null ? countyFlowerColor.hashCode() : 0);
        result = 31 * result + (mainCountyFlowerId != null ? mainCountyFlowerId.hashCode() : 0);
        return result;
    }
}
