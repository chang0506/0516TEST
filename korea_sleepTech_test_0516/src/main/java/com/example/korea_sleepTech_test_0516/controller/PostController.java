package com.example.korea_sleepTech_test_0516.controller;

import com.example.korea_sleepTech_test_0516.common.ApiMappingPattern;
import com.example.korea_sleepTech_test_0516.dto.requestDto.PostCreateReqDto;
import com.example.korea_sleepTech_test_0516.dto.responseDto.PostDetailResDto;
import com.example.korea_sleepTech_test_0516.dto.responseDto.PostResDto;
import com.example.korea_sleepTech_test_0516.dto.responseDto.ResponseDto;
import com.example.korea_sleepTech_test_0516.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // @ResponseBody + @Controller
@RequestMapping(ApiMappingPattern.POST_API)
@RequiredArgsConstructor // 생성자 주입
public class PostController {
    private final PostService postService;

    @GetMapping
    public ResponseEntity<ResponseDto<List<PostResDto>>> getAllPosts() {
        ResponseDto<List<PostResDto>> posts = postService.getAllPosts();
        return ResponseEntity.status(HttpStatus.OK).body(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<PostDetailResDto>> getPostById(@PathVariable Long id) {
        ResponseDto<PostDetailResDto> post = postService.getPostById(id);
        return ResponseEntity.status(HttpStatus.OK).body(post);
    }

    @PostMapping
    public ResponseEntity<ResponseDto<PostDetailResDto>> createPost(@AuthenticationPrincipal String userName, @Valid @RequestBody PostCreateReqDto dto) {
        ResponseDto<PostDetailResDto> post = postService.createPost(userName, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }
}
