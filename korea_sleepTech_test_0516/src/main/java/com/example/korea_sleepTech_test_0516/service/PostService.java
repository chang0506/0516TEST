package com.example.korea_sleepTech_test_0516.service;

import com.example.korea_sleepTech_test_0516.dto.requestDto.PostCreateReqDto;
import com.example.korea_sleepTech_test_0516.dto.responseDto.PostDetailResDto;
import com.example.korea_sleepTech_test_0516.dto.responseDto.PostResDto;
import com.example.korea_sleepTech_test_0516.dto.responseDto.ResponseDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    ResponseDto<List<PostResDto>> getAllPosts();

    ResponseDto<PostDetailResDto> getPostById(Long id);

    ResponseDto<PostDetailResDto> createPost(String userName, @Valid PostCreateReqDto dto);
}
