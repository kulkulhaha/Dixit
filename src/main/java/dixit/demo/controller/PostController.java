package dixit.demo.controller;

import dixit.demo.dto.CreatePostDto;
import dixit.demo.dto.FindPostDto;
import dixit.demo.dto.Result;
import dixit.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/post/new")
    public Long create(@RequestBody CreatePostDto createPostDto){
        return postService.save(createPostDto);
    }

    @GetMapping("/post/{postId}")
    public Result<FindPostDto> findOne(@PathVariable Long postId){
        return new Result<>(postService.findOne(postId));
    }

    @GetMapping("/posts")
    public Result findAllLeft(){
        return new Result<>(postService.findAll());
    }

    @DeleteMapping("/post/{postId}")
    public void delete(@PathVariable Long postId){
        postService.delete(postId);
    }
}
