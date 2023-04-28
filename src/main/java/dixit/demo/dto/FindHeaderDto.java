package dixit.demo.dto;

import dixit.demo.domain.Header;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class FindHeaderDto {
    private Long id;
    private String name;
    private List<Long> childIds;
    private Long parentId;

    @Builder
    public FindHeaderDto(Long id, String name, List<Long> childIds,Long parentId) {
        this.id = id;
        this.name = name;
        this.childIds = childIds;
        this.parentId = parentId;
    }

    public FindHeaderDto(Header header) {
        id = header.getId();
        name = header.getName();
        childIds = header.getChild().stream().map(Header::getId).collect(Collectors.toList());
        parentId = header.getParent()!=null?header.getParent().getId():null;
    }
}
