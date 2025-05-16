package com.example.korea_sleepTech_test_0516.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailResDto {
    private Long id;
    private String username;
    private String role;
}
