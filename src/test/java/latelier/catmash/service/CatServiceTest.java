package latelier.catmash.service;

import latelier.catmash.dto.CatDTO;
import latelier.catmash.mapper.CatMapper;
import latelier.catmash.model.Cat;
import latelier.catmash.repository.CatRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CatServiceTest {

    @Mock
    CatRepository catRepository;

    @Mock
    CatMapper catMapper;

    @InjectMocks
    CatService catService;

    @Test
    public void testGetTwoRandomCats() {
        Cat cat1 = new Cat("cat1","url1", 0);
        Cat cat2 = new Cat("cat2","url2", 0);
        List<Cat> cats = List.of(cat1, cat2);
        CatDTO catDTO1 = new CatDTO("cat1","url1", 0);
        CatDTO catDTO2 = new CatDTO("cat2","url2", 0);
        List<CatDTO> catDTOsExpected = List.of(catDTO1, catDTO2);

        when(catRepository.findTwoRandomCats()).thenReturn(cats);
        when(catMapper.entitiesToDTOs(cats)).thenReturn(catDTOsExpected);

        List<CatDTO> catDTOsResults = catService.getTwoRandomCats();

        assertEquals(catDTOsExpected, catDTOsResults);
    }

    @Test
    public void testRanking() {
        Cat cat1 = new Cat("cat1","url1", 1);
        Cat cat2 = new Cat("cat2","url2", 2);
        Cat cat3 = new Cat("cat3","url3", 3);
        List<Cat> cats = List.of(cat1, cat2, cat3);
        CatDTO catDTO1 = new CatDTO("cat1","url1", 1);
        CatDTO catDTO2 = new CatDTO("cat2","url2", 2);
        CatDTO catDTO3 = new CatDTO("cat3","url3", 3);
        List<CatDTO> catDTOsExpected = List.of(catDTO1, catDTO2, catDTO3);

        when(catRepository.findAllByOrderByScoreDesc()).thenReturn(cats);
        when(catMapper.entitiesToDTOs(cats)).thenReturn(catDTOsExpected);

        List<CatDTO> catDTOsResults = catService.ranking();

        assertEquals(catDTOsExpected, catDTOsResults);
    }
}
