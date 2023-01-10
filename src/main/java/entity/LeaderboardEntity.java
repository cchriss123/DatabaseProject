package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "leaderboard", schema = "landskapsquiz", catalog = "")
public class LeaderboardEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "leaderboardId")
    private int leaderboardId;
    @Basic
    @Column(name = "leaderBoardName")
    private String leaderBoardName;
    @Basic
    @Column(name = "leaderBoardPoints")
    private Integer leaderBoardPoints;

    public int getLeaderboardId() {
        return leaderboardId;
    }

    public void setLeaderboardId(int leaderboardId) {
        this.leaderboardId = leaderboardId;
    }

    public String getLeaderBoardName() {
        return leaderBoardName;
    }

    public void setLeaderBoardName(String leaderBoardName) {
        this.leaderBoardName = leaderBoardName;
    }

    public Integer getLeaderBoardPoints() {
        return leaderBoardPoints;
    }

    public void setLeaderBoardPoints(Integer leaderBoardPoints) {
        this.leaderBoardPoints = leaderBoardPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeaderboardEntity that = (LeaderboardEntity) o;

        if (leaderboardId != that.leaderboardId) return false;
        if (leaderBoardName != null ? !leaderBoardName.equals(that.leaderBoardName) : that.leaderBoardName != null)
            return false;
        if (leaderBoardPoints != null ? !leaderBoardPoints.equals(that.leaderBoardPoints) : that.leaderBoardPoints != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = leaderboardId;
        result = 31 * result + (leaderBoardName != null ? leaderBoardName.hashCode() : 0);
        result = 31 * result + (leaderBoardPoints != null ? leaderBoardPoints.hashCode() : 0);
        return result;
    }
}
