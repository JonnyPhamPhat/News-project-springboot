package newsproject.news.converter;

import newsproject.news.dto.NewDTO;
import newsproject.news.entity.NewEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class NewConverter {

    public NewEntity toEntity(NewDTO dto){
        NewEntity newEntity = new NewEntity();
        newEntity.setTitle(dto.getTitle());
        newEntity.setContent(dto.getContent());
        newEntity.setShortDescription(dto.getShortDescription());
        newEntity.setThumbNail(dto.getThumbNail());
        return newEntity;
    }

    public NewDTO toDTO(NewEntity entity){
        NewDTO newDTO = new NewDTO();
        if(entity.getId() != null){
            newDTO.setId(entity.getId());
        }
        newDTO.setTitle( entity.getTitle());
        newDTO.setContent( entity.getContent());
        newDTO.setShortDescription( entity.getShortDescription());
        newDTO.setThumbNail( entity.getThumbNail());
        return newDTO;
    }

    public NewEntity toEntitys(NewDTO dto, NewEntity entity){
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setShortDescription(dto.getShortDescription());
        entity.setThumbNail(dto.getThumbNail());
        return entity;
    }
}
