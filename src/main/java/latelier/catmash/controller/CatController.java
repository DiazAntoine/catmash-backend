package latelier.catmash.controller;

import latelier.catmash.dto.CatDTO;
import latelier.catmash.service.CatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cats", produces = "application/json")
//@CrossOrigin(origins = "http://localhost:5173")
@CrossOrigin(origins = "https://catmash-frontend.onrender.com/")
public class CatController {

    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    /**
     * Get two random Cats
     * @return List of Cats
     */
    @GetMapping("/get_two_random_cats")
    public List<CatDTO> getTwoRandomCats() {
        return catService.getTwoRandomCats();
    }

     /**
     * Get all cats sorted by score
     * @return List of Cats
     */
    @GetMapping("/ranking")
    public List<CatDTO> ranking() {
        return catService.ranking();
    }
}