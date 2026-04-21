package latelier.catmash.repository;

import latelier.catmash.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CatRepository extends JpaRepository<Cat, String> {

    /**
     * Native query that returns two random Cats
     * @return List of Cats
     */
    @Query(
            value = "SELECT * FROM cat ORDER BY RANDOM() LIMIT 2",
            nativeQuery = true
    )
    List<Cat> findTwoRandomCats();

    /**
     * Query that returns all Cats sorted by decreasing score
     * @return List of Cats
     */
    List<Cat> findAllByOrderByScoreDesc();
}