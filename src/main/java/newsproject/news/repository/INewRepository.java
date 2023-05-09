package newsproject.news.repository;

import newsproject.news.entity.NewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INewRepository extends JpaRepository<NewEntity, Long> {
}
