package com.example.korea_sleepTech_test_0516.service;

import com.example.korea_sleepTech_test_0516.dto.requestDto.UserLogInReqDto;
import com.example.korea_sleepTech_test_0516.dto.requestDto.UserSignUpReqDto;
import com.example.korea_sleepTech_test_0516.dto.responseDto.ResponseDto;
import com.example.korea_sleepTech_test_0516.dto.responseDto.UserLogInResDto;
import com.example.korea_sleepTech_test_0516.dto.responseDto.UserSignUpResDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    ResponseDto<UserSignUpResDto> signup(@Valid UserSignUpReqDto dto);

    ResponseDto<UserLogInResDto> login(@Valid UserLogInReqDto dto);
}
