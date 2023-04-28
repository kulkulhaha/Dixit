package dixit.demo.service;

import dixit.demo.domain.Header;
import dixit.demo.dto.CreateHeaderDto;
import dixit.demo.dto.FindHeaderDto;
import dixit.demo.exception.NoSuchHeader;
import dixit.demo.repository.HeaderRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class HeaderServiceTest {
    @Autowired
    HeaderRepository headerRepository;
    @Autowired
    HeaderService headerService;
    @Autowired
    EntityManager em;

    @Test
    @DisplayName("헤더 저장")
    void name() {

        Long saved = headerService.save(CreateHeaderDto.builder().name("새로운 헤더").build());
        Header header = headerRepository.findById(saved).orElseThrow(NoSuchHeader::new);
        assertThat(header.getName()).isEqualTo("새로운 헤더");
        List<Header> family = headerRepository.findFamily();
        Header header1 = family.get(0);
        System.out.println("header1.getName() = " + header1.getName());

    }

    @Test
    @DisplayName("전체 헤더 꺼내기")
    void name2() {
        headerRepository.save(Header.builder().name("새로운 헤더1").build());
        headerRepository.save(Header.builder().name("새로운 헤더2").build());
        List<FindHeaderDto> all = headerService.findAll();
        all.forEach(h->System.out.println(h.getName()));
    }

    @Test
    @DisplayName("전체 헤더 꺼내기 parent - child")
    void name4() {
        Header header1 = Header.builder().name("헤더1").build();
        Header header2 = Header.builder().name("헤더2").build();
        header2.addParent(header1);
        Header header3 = Header.builder().name("헤더3").build();
        header3.addParent(header1);
        Header header4 = Header.builder().name("헤더4").build();
        headerRepository.save(header1);
        headerRepository.save(header2);
        headerRepository.save(header3);
        headerRepository.save(header4);
        em.flush();
        em.clear();
        List<FindHeaderDto> all = headerService.findAll();
        all.forEach(h->System.out.println(h.getName()));
        List<Long> childIds = all.get(0).getChildIds();
        System.out.println("childIds = " + childIds);

    }

    @Test
    @DisplayName("Dto 변환 체크")
    void name3() {
        Header header1 = Header.builder().name("헤더1").build();
        Header header2 = Header.builder().name("헤더2").build();
        header2.addParent(header1);
        Header header3 = Header.builder().name("헤더3").build();
        header3.addParent(header1);
        Header header4 = Header.builder().name("헤더4").build();

        FindHeaderDto findHeaderDto1 = new FindHeaderDto(header1);
        FindHeaderDto findHeaderDto2 = new FindHeaderDto(header2);
        FindHeaderDto findHeaderDto3 = new FindHeaderDto(header3);
        System.out.println("findHeaderDto3.getName() = " + findHeaderDto3.getName());
        System.out.println("findHeaderDto2.getName() = " + findHeaderDto2.getName());
        System.out.println("findHeaderDto1.getName() = " + findHeaderDto1.getName());

    }

    @Test
    @DisplayName("부모가 있는 헤더 post 요청")
    void save() {
        CreateHeaderDto header1 = CreateHeaderDto.builder().name("헤더1").build();
        CreateHeaderDto header2 = CreateHeaderDto.builder().name("헤더2").parentHeaderId(1L).build();
        headerService.save(header1);
        headerService.save(header2);
        System.out.println("header1 = " + headerRepository.findById(1L).get().getChild().size());
        assertThat(headerRepository.findById(1L).get().getChild().size()).isEqualTo(1);


    }
}