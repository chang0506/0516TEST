package com.example.korea_sleepTech_test_0516.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserSignUpReqDto {
    private String username;
    private String password;
    private String confirmPassword;
    private String role;
}
