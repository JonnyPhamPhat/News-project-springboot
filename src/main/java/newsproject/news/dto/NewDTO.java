package newsproject.news.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NewDTO extends AbstractDTO<NewDTO> {
    private String title;
    private String content;
    private String shortDescription;
    private String categoryCode;
    private String thumbNail;
}
