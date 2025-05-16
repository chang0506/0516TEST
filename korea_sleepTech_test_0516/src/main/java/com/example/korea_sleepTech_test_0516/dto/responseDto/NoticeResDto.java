package com.example.korea_sleepTech_test_0516.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class NoticeResDto {
    private Long id;
    private String title;
    private String content;
}