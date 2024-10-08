package TRaMis8khae.starbucks.media.infrastructure;

import TRaMis8khae.starbucks.media.entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MediaRepository extends JpaRepository<Media, Long> {

    List<Optional<Media>> findByThumbCheckedIsTrue();

}