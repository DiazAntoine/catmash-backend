package latelier.catmash.repository;

import latelier.catmash.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository  extends JpaRepository<Vote, Long> {

}
