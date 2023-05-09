package newsproject.news.api.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import newsproject.news.dto.NewDTO;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NewOutput {
    private int page;
    private int totalPage;
    private List<NewDTO> listResult = new ArrayList<>();
}
