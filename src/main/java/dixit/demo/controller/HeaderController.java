package dixit.demo.controller;

import dixit.demo.dto.CreateHeaderDto;
import dixit.demo.dto.Result;
import dixit.demo.service.HeaderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HeaderController {

    private final HeaderService headerService;

    @GetMapping("/header")
    public Result findAll(){
        return new Result(headerService.findAll());
    }

    @PostMapping("/header/new")
    public Long add(@RequestBody @Valid CreateHeaderDto createHeaderDto){
        return headerService.save(createHeaderDto);
    }

}
