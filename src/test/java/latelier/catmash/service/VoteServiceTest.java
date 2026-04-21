package latelier.catmash.service;

import jakarta.persistence.EntityNotFoundException;
import latelier.catmash.dto.VoteDTO;
import latelier.catmash.model.Cat;
import latelier.catmash.model.Vote;
import latelier.catmash.repository.CatRepository;
import latelier.catmash.repository.VoteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class VoteServiceTest {

    @Mock
    CatRepository catRepository;

    @Mock
    VoteRepository voteRepository;

    @InjectMocks
    VoteService voteService;

    @Test
    public void count() {
        Long countExpected = 1L;
        when(voteService.count()).thenReturn(countExpected);
        assertEquals(countExpected, voteService.count());
    }

    @Test
    public void voteCatNotFound() {
        VoteDTO voteDTO = new VoteDTO("cat1", "cat2");

        when(catRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> voteService.vote(voteDTO));

        verify(voteRepository, never()).save(any());
    }

    @Test
    public void vote() {
        Cat catWinner = new Cat("catWinner","url1", 0);
        Cat catLoser = new Cat("catLoser","url2", 0);
        VoteDTO voteDTO = new VoteDTO(catWinner.getId(), catLoser.getId());

        when(catRepository.findById(voteDTO.getWinnerId())).thenReturn(Optional.of(catWinner));
        when(catRepository.findById(voteDTO.getLoserId())).thenReturn(Optional.of(catLoser));

        ArgumentCaptor<Vote> captor =
                ArgumentCaptor.forClass(Vote.class);

        voteService.vote(voteDTO);

        assertEquals(1, catWinner.getScore());

        verify(catRepository).save(catWinner);
        verify(voteRepository).save(captor.capture());

        Vote savedVote = captor.getValue();

        assertEquals(savedVote.getWinnerCat(), catWinner);
        assertEquals(savedVote.getLoserCat(), catLoser);

    }
}
