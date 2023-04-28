package dixit.demo.repository;

import dixit.demo.domain.Post;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> , HeaderRepositoryCustom {
    @EntityGraph(attributePaths = {"comments"})
    Optional<Post> findOneById(Long id);



}
