package dixit.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dixit.demo.domain.Header;
import dixit.demo.dto.CreateHeaderDto;
import dixit.demo.repository.HeaderRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class HeaderControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    HeaderRepository headerRepository;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void findAll() throws Exception {
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
        mockMvc.perform(get("http://localhost8080/header"))
                .andExpect(jsonPath("$.data[0].childIds.size()").value(2))
                .andDo(print());
    }

    @Test
    void hasParent() throws Exception {
        CreateHeaderDto header1 = CreateHeaderDto.builder().name("헤더1").build();
        CreateHeaderDto header2 = CreateHeaderDto.builder().name("헤더2").parentHeaderId(1L).build();
        String s1 = objectMapper.writeValueAsString(header1);
        String s2 = objectMapper.writeValueAsString(header2);
        mockMvc.perform(post("http://localhost8080/header/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(s1));
        mockMvc.perform(post("http://localhost8080/header/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(s1));
        mockMvc.perform(get("http://localhost8080/header")
                .contentType(MediaType.APPLICATION_JSON)
                .content(s1)).andDo(print());
        System.out.println("s2 = " + s2);
        System.out.println("s1 = " + s1);
        //TODO long 타입을 post요청 으로 받는게 안되는 듯 하다.
    }
}