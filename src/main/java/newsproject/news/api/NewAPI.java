package newsproject.news.api;

import newsproject.news.Service.INewService;
import newsproject.news.api.output.NewOutput;
import newsproject.news.dto.NewDTO;
import newsproject.news.entity.NewEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/new")
@CrossOrigin
public class NewAPI {

    @Autowired
    private INewService newService;
//
//    @GetMapping("")
//    public List<NewDTO> getAllNew(){
//        return newService.getAll();
//    }

    @GetMapping("/{id}")
    public Optional<NewEntity> getOneNew(@PathVariable("id") long id){
        return newService.getOne(id);
    }

    @GetMapping("")
    public NewOutput showNew(@RequestParam("page") int page, @RequestParam("limit") int limit){
        NewOutput newOutput = new NewOutput();
        newOutput.setPage(page);
        Pageable pageable = PageRequest.of(page - 1, limit);
        newOutput.setListResult(newService.findAll(pageable));
        newOutput.setTotalPage((int) Math.ceil((double) (newService.totalItem())/limit));
        return newOutput;
    }

    @PostMapping("")
    public NewDTO createNew(@RequestBody NewDTO model){
        return newService.save(model);
    }

    @PutMapping("/{id}")
    public NewDTO updateNew(@RequestBody NewDTO model, @PathVariable("id") long id){
        model.setId(id);
        return newService.save(model);
    }

    @DeleteMapping("/{id}")
    public void deleteNew(@PathVariable("id") long id){
        newService.delete(id);
    }
}
