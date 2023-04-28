package dixit.demo.service;

import dixit.demo.domain.Header;
import dixit.demo.dto.CreateHeaderDto;
import dixit.demo.dto.FindHeaderDto;
import dixit.demo.exception.NoSuchHeader;
import dixit.demo.repository.HeaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HeaderService {

    private final HeaderRepository headerRepository;

    public Long save(CreateHeaderDto createHeaderDto){
        Header header = Header.builder()
                .name(createHeaderDto.getName())
                .build();
        hasParent(createHeaderDto, header);
        Header saved = headerRepository.save(header);
        return saved.getId();

    }
    public List<FindHeaderDto> findAll(){
        return headerRepository.findFamily().stream().map(FindHeaderDto::new).collect(Collectors.toList());
    }

    private void hasParent(CreateHeaderDto createHeaderDto, Header header) {
        if (createHeaderDto.hasParent()){
            Header parent = headerRepository.findById(createHeaderDto.getParentHeaderId()).orElseThrow(NoSuchHeader::new);
            header.addParent(parent);
        }
    }
}
