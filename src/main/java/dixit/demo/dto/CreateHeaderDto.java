package dixit.demo.dto;

import dixit.demo.domain.Header;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateHeaderDto {

    private String name;
    private Long parentHeaderId;

    @Builder
    public CreateHeaderDto(String name, Long parentHeaderId) {
        this.name = name;
        this.parentHeaderId = parentHeaderId;
    }
    public Boolean hasParent(){
        return parentHeaderId != null;
    }

}
