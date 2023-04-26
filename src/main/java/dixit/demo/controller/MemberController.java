package dixit.demo.controller;

import dixit.demo.dto.CreateMemberDto;
import dixit.demo.dto.FindMemberDto;
import dixit.demo.dto.Result;
import dixit.demo.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/member/new")
    public Long register(@RequestBody CreateMemberDto createMemberDto){
        return memberService.save(createMemberDto);
    }

    @GetMapping("/member/{memberId}")
    public Result<FindMemberDto> get(@PathVariable Long memberId){
        return new Result<>(memberService.findOne(memberId));

    }

    @GetMapping("/members")
    public Result members(){
        return new Result(memberService.findAll());
    }

    @DeleteMapping("/member/{memberId}")
    public void delete(@PathVariable Long memberId){
        memberService.remove(memberId);
    }



}
