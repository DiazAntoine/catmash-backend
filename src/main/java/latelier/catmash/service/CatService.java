package latelier.catmash.service;

import latelier.catmash.dto.CatDTO;
import latelier.catmash.mapper.CatMapper;
import latelier.catmash.model.Cat;
import latelier.catmash.repository.CatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {

    private final CatRepository catRepository;
    private final CatMapper catMapper;

    public CatService(CatRepository catRepository, CatMapper catMapper) {
        this.catRepository = catRepository;
        this.catMapper = catMapper;
    }

    /**
     * Get two random Cats
     * @return List of Cats
     */
    public List<CatDTO> getTwoRandomCats() {
        return catMapper.entitiesToDTOs(
                catRepository.findTwoRandomCats()
        );
    }

    /**
     * Get all cats sorted by score
     * @return List of Cats
     */
    public List<CatDTO> ranking() {
        return catMapper.entitiesToDTOs(
                catRepository.findAllByOrderByScoreDesc()
        );
    }

}