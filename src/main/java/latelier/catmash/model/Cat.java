package latelier.catmash.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cat {

    @Id
    private String id;

    private String url;

    private int score;

    public Cat() {
    }

    public Cat(String id, String url, int score) {
        this.id = id;
        this.url=url;
        this.score=score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) { this.score = score; }

    public void incrementScore() {
        this.score++;
    }
}
