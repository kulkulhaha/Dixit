package dixit.demo.service;

import dixit.demo.domain.MemberEditor;
import dixit.demo.dto.CreateMemberDto;
import dixit.demo.domain.Member;
import dixit.demo.dto.FindMemberDto;
import dixit.demo.dto.UpdateMemberDto;
import dixit.demo.exception.NoSuchMember;
import dixit.demo.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public Long save(CreateMemberDto createMemberDto){
        Member member = createMemberDto.toEntity();
        memberRepository.save(member);
        return member.getId();
    }

    public FindMemberDto findOne(Long id){
        return new FindMemberDto(memberRepository.findById(id).orElseThrow(NoSuchMember::new));
    }

    public List<FindMemberDto> findAll(){
        return memberRepository.findAll().stream().map(FindMemberDto::new).collect(Collectors.toList());
    }

    public void edit(Long id, UpdateMemberDto updateMemberDto){
        Member member = memberRepository.findById(id).orElseThrow(NoSuchMember::new);
        MemberEditor.MemberEditorBuilder editor = member.toEditor();
        MemberEditor memberEditor = updateMemberDto.updateEdit(editor);
        member.edit(memberEditor);

    }

    public void remove(Long id){
        Member member = memberRepository.findById(id).orElseThrow(NoSuchMember::new);
        memberRepository.delete(member);
    }

}
