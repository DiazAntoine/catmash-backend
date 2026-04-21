package latelier.catmash.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import latelier.catmash.dto.VoteDTO;
import latelier.catmash.model.Cat;
import latelier.catmash.model.Vote;
import latelier.catmash.repository.CatRepository;
import latelier.catmash.repository.VoteRepository;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

    private final VoteRepository voteRepository;
    private final CatRepository catRepository;

    public VoteService(CatRepository catRepository, VoteRepository voteRepository) {
        this.catRepository = catRepository;
        this.voteRepository = voteRepository;
    }

    /**
     * Record a vote for the cutest between two cats.
     * Increment the score of the winner Cat and create the new Vote in DB
     *
     * @param voteDTO the vote made by user
     */
    @Transactional
    public void vote(VoteDTO voteDTO) {

        String catWinnerId = voteDTO.getWinnerId();
        String catLoserId = voteDTO.getLoserId();

        Cat catWinner = catRepository.findById(catWinnerId).orElseThrow(() -> new EntityNotFoundException("Cat not found with id " + catWinnerId));
        Cat catLoser = catRepository.findById(catLoserId).orElseThrow(() -> new EntityNotFoundException("Cat not found with id " + catLoserId));

        catWinner.incrementScore();

        Vote vote = new Vote(catWinner, catLoser);

        catRepository.save(catWinner);
        voteRepository.save(vote);
    }

    /**
     * Count the number of vote made
     * @return number of vote
     */
    public long count() {
        return voteRepository.count();
    }
}
