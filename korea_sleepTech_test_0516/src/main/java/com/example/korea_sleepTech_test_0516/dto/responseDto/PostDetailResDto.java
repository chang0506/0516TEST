package com.example.korea_sleepTech_test_0516.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDetailResDto {
    private Long id;
    private String title;
    private String content;
    private Long authorId;
}
