package akram.cherkaoui.motusbe.repositories;

import akram.cherkaoui.motusbe.entities.Game;
import akram.cherkaoui.motusbe.entities.User;
import akram.cherkaoui.motusbe.enums.Difficulty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GameRepository extends JpaRepository<Game, UUID> {

    List<Game> findByUser(User user);

    List<Game> findByDifficulty(Difficulty difficulty);

    List<Game> findByUserAndDifficulty(User user, Difficulty difficulty);
}