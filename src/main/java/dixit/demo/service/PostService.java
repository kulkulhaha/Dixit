package dixit.demo.service;

import dixit.demo.domain.Post;
import dixit.demo.dto.CreatePostDto;
import dixit.demo.dto.FindPostDto;
import dixit.demo.exception.NoSuchPost;
import dixit.demo.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostRepository postRepository;

    public Long save(CreatePostDto createPostDto){
        return postRepository.save(createPostDto.toEntity()).getId();
    }

    public FindPostDto findOne(Long id){
        return new FindPostDto(postRepository.findOneById(id).orElseThrow(NoSuchPost::new));
    }

    public List<FindPostDto> findAll(){
        return postRepository.findAllWithMember().stream().map(FindPostDto::new).collect(Collectors.toList());
    }

    public void delete(Long id){
        postRepository.findById(id).orElseThrow(NoSuchPost::new);
        postRepository.deleteById(id);
    }


}