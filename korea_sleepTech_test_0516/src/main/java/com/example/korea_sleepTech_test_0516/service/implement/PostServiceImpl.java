package com.example.korea_sleepTech_test_0516.service.implement;

import com.example.korea_sleepTech_test_0516.common.ResponseMessage;
import com.example.korea_sleepTech_test_0516.dto.requestDto.PostCreateReqDto;
import com.example.korea_sleepTech_test_0516.dto.responseDto.PostDetailResDto;
import com.example.korea_sleepTech_test_0516.dto.responseDto.PostResDto;
import com.example.korea_sleepTech_test_0516.dto.responseDto.ResponseDto;
import com.example.korea_sleepTech_test_0516.entity.Post;
import com.example.korea_sleepTech_test_0516.entity.User;
import com.example.korea_sleepTech_test_0516.repository.PostRepository;
import com.example.korea_sleepTech_test_0516.repository.UserRepository;
import com.example.korea_sleepTech_test_0516.service.PostService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    // 게시글 전체 조회 (권한 X)
    @Override
    @Transactional(readOnly = true)
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
    @Transactional(readOnly = true)
    public ResponseDto<PostDetailResDto> getPostById(Long id) {
        PostDetailResDto data = null;
        Post post = postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(ResponseMessage.NOT_EXISTS_POST + id));
        data = PostDetailResDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getTitle())
                .author(post.getAuthor().getUsername())
                .build();
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);



    }

    @Override
    public ResponseDto<PostDetailResDto> createPost(String userName, PostCreateReqDto dto) {
        PostDetailResDto responseDto = null;
        User user = userRepository.findByUsername(userName)
                .orElse(null);

        if (user == null) {
            return ResponseDto.setFailed(ResponseMessage.NOT_EXISTS_USER);
        }

        Post newPost = Post.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .author(user)
                .build();

        Post saved = postRepository.save(newPost);

        responseDto = PostDetailResDto.builder()
                .id(saved.getId())
                .title(saved.getTitle())
                .content(saved.getContent())
                .author(saved.getAuthor().getUsername())
                .build();

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, responseDto);
    }
}
