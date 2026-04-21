package latelier.catmash.controller;

import latelier.catmash.dto.VoteDTO;
import latelier.catmash.service.VoteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/votes", produces = "application/json")
//CrossOrigin(origins = "http://localhost:5173")
@CrossOrigin(origins = "https://catmash-frontend.onrender.com/")
public class VoteController {

    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    /**
     * Record a Vote for the cutest between two cats.
     * @param vote the vote made by user
     */
    @PostMapping("/vote")
    public void vote(@RequestBody VoteDTO vote) {
        voteService.vote(vote);
    }

    /**
     * Count the number of vote made
     * @return number of vote
     */
    @GetMapping("/count")
    public long count() {
        return voteService.count();
    }

}
