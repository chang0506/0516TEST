package com.example.korea_sleepTech_test_0516.service;

import com.example.korea_sleepTech_test_0516.dto.responseDto.PostDetailResDto;
import com.example.korea_sleepTech_test_0516.dto.responseDto.PostResDto;
import com.example.korea_sleepTech_test_0516.dto.responseDto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    ResponseDto<List<PostResDto>> getAllPosts();

    ResponseDto<PostDetailResDto> getPostById(Long id);
}
