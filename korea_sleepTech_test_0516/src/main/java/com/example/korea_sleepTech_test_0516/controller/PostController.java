package com.example.korea_sleepTech_test_0516.controller;

import com.example.korea_sleepTech_test_0516.common.ApiMappingPattern;
import com.example.korea_sleepTech_test_0516.dto.responseDto.PostDetailResDto;
import com.example.korea_sleepTech_test_0516.dto.responseDto.PostResDto;
import com.example.korea_sleepTech_test_0516.dto.responseDto.ResponseDto;
import com.example.korea_sleepTech_test_0516.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
