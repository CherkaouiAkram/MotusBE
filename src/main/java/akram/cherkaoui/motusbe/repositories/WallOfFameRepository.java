package akram.cherkaoui.motusbe.repositories;

import akram.cherkaoui.motusbe.entities.WallOfFame;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface WallOfFameRepository extends JpaRepository<WallOfFame, UUID> {
    Optional<WallOfFame> findByUserId(UUID userId);
}