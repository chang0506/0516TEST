package com.example.korea_sleepTech_test_0516.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserLogInReqDto {
    private String username;
    private String password;
}
