package latelier.catmash.repository;

import latelier.catmash.model.Cat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DataJpaTest
class CatRepositoryTest {

    @Autowired
    CatRepository repository;

    @BeforeEach
    void setup() {
        repository.save(new Cat("1", "url1", 0));
        repository.save(new Cat("2", "url2", 1));
        repository.save(new Cat("3", "url3", 2));
        repository.save(new Cat("4", "url4", 3));
    }

    @Test
    void testFindTwoRandomCats() {
        List<Cat> cats = repository.findTwoRandomCats();

        assertEquals(2, cats.size());
        assertNotEquals(cats.get(0).getId(), cats.get(1).getId());
    }
}
