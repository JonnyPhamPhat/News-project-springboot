package newsproject.news.Service.impl;

import newsproject.news.Service.INewService;
import newsproject.news.converter.NewConverter;
import newsproject.news.dto.NewDTO;
import newsproject.news.entity.CategoryEntity;
import newsproject.news.entity.NewEntity;
import newsproject.news.repository.ICategoryRepository;
import newsproject.news.repository.INewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NewService implements INewService {
    @Autowired
    private INewRepository newRepository;

    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    private NewConverter newConverter;

    @Override
    public NewDTO save(NewDTO newDTO) {
        NewEntity newEntity = new NewEntity();
        if(newEntity != null){
            if(newDTO.getId() != null){
                NewEntity oldNew = newRepository.getById(newDTO.getId());
                newEntity = newConverter.toEntitys(newDTO, oldNew);
            }
            else{
                newEntity = newConverter.toEntity(newDTO);
            }
                CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
                newEntity.setCategory(categoryEntity);
                newEntity = newRepository.save(newEntity);
                return newConverter.toDTO(newEntity);
        }
            return null;
    }

    @Override
    public NewDTO update(Long id, NewDTO newDTO) {
        if(newDTO != null){
            NewEntity newEntity = newRepository.getById(id);
            if(newEntity != null){

                CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
                newEntity = newConverter.toEntitys(newDTO, newEntity);
                newEntity.setCategory(categoryEntity);
                newEntity = newRepository.save(newEntity);
                return newConverter.toDTO(newEntity);
            }
        }
        return null;
    }

    @Override
    public void delete(long id) {
        NewDTO newDTO = new NewDTO();
        if(id >= 1){
            NewEntity newEntity = newRepository.getById(id);
            if(newDTO != null){
                newRepository.delete(newEntity);
            }
        }
    }

    @Override
    public List<NewDTO> getAll() {
        return ((List<NewEntity>) newRepository.findAll()).stream().map(
                this:: getNewDTO
        ).collect(Collectors.toList());
    }

    @Override
    public List<NewDTO> findAll(Pageable pageable) {
        List<NewDTO> result = new ArrayList<>();
        List<NewEntity> newEntities = newRepository.findAll(pageable).getContent();
        for(NewEntity item:newEntities){
            NewDTO newDTO = newConverter.toDTO(item);
            result.add(newDTO);
        }
        return result;
    }

    @Override
    public Optional<NewEntity> getOne(Long id) {
        return newRepository.findById(id);
    }

    @Override
    public int totalItem() {
        return (int) newRepository.count();
    }

    public NewDTO getNewDTO(NewEntity newEntity){
        return newConverter.toDTO(newEntity);
    }
}
