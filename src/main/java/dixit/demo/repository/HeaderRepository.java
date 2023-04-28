package dixit.demo.repository;

import dixit.demo.domain.Header;
import org.hibernate.annotations.BatchSize;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HeaderRepository extends JpaRepository<Header,Long> {

    @Query("select h from Header h left join fetch h.parent")
    List<Header> findFamily();
}
