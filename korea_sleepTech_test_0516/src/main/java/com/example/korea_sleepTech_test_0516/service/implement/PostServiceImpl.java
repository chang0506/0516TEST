package com.example.korea_sleepTech_test_0516.service.implement;

import com.example.korea_sleepTech_test_0516.common.ResponseMessage;
import com.example.korea_sleepTech_test_0516.dto.responseDto.PostDetailResDto;
import com.example.korea_sleepTech_test_0516.dto.responseDto.PostResDto;
import com.example.korea_sleepTech_test_0516.dto.responseDto.ResponseDto;
import com.example.korea_sleepTech_test_0516.entity.Post;
import com.example.korea_sleepTech_test_0516.repository.PostRepository;
import com.example.korea_sleepTech_test_0516.service.PostService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    // 게시글 전체 조회 (권한 X)
    @Override
    public ResponseDto<List<PostResDto>> getAllPosts() {
        List<PostResDto> data = null;

        List<Post> posts = postRepository.findAll();

        data = posts.stream()
                .map(post -> PostResDto.builder()
                        .id(post.getId())
                        .title(post.getTitle())
                        .content(post.getContent())
                        .authorId(post.getAuthor().getId())
                        .build())
                .collect(Collectors.toList());

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 게시글 상세 조회 (권한 X)
    @Override
    public ResponseDto<PostDetailResDto> getPostById(Long id) {
        PostDetailResDto data = null;
        Post post = postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(ResponseMessage.NOT_EXISTS_POST + id));
        data = PostDetailResDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getTitle())
                .authorId(post.getAuthor().getId())
                .build();
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);



    }
}
