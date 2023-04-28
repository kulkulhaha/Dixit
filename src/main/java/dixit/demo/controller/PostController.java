package dixit.demo.controller;

import dixit.demo.dto.CreatePostDto;
import dixit.demo.dto.FindPostDto;
import dixit.demo.dto.Result;
import dixit.demo.dto.UpdatePostDto;
import dixit.demo.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/post/new")
    public Long create(@RequestBody @Valid CreatePostDto createPostDto){
        return postService.save(createPostDto);
    }

    @GetMapping("/post/{postId}")
    public Result<FindPostDto> findOne(@PathVariable Long postId){
        return new Result<>(postService.findOne(postId));
    }
    @PatchMapping("/post/{postId}")
    public void edit(@PathVariable Long postId, @Valid @RequestBody UpdatePostDto updatePostDto){
        postService.edit(postId,updatePostDto);
    }

    @GetMapping("/posts")
    public Result findAll(){
        return new Result<>(postService.findAll());
    }

    @DeleteMapping("/post/{postId}")
    public void delete(@PathVariable Long postId){
        postService.delete(postId);
    }
}
