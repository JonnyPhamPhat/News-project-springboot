package newsproject.news.Service;

import newsproject.news.dto.NewDTO;
import newsproject.news.entity.NewEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface INewService {
    NewDTO save(NewDTO newDTO);
    NewDTO update(Long id, NewDTO newDTO);
    void delete(long id);
    List<NewDTO> getAll();
    List<NewDTO> findAll(Pageable pageable);
    Optional<NewEntity> getOne(Long id);
    int totalItem();
}
