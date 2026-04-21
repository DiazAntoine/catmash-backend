package latelier.catmash.model;

import jakarta.persistence.*;

@Entity
public class Vote {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "winner_id")
    private Cat winnerCat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loser_id")
    private Cat loserCat;

    public Vote() {
    }

    public Vote(Cat winnerCat, Cat loserCat) {
        this.winnerCat = winnerCat;
        this.loserCat = loserCat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cat getWinnerCat() {
        return winnerCat;
    }

    public void setWinnerCat(Cat winnerCat) {
        this.winnerCat = winnerCat;
    }

    public Cat getLoserCat() {
        return loserCat;
    }

    public void setLoserCat(Cat loserCat) {
        this.loserCat = loserCat;
    }

}
