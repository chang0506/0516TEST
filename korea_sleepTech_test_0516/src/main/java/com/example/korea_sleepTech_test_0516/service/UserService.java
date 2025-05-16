package com.example.korea_sleepTech_test_0516.service;

import com.example.korea_sleepTech_test_0516.dto.responseDto.ResponseDto;
import com.example.korea_sleepTech_test_0516.dto.responseDto.UserDetailResDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    ResponseDto<UserDetailResDto> getUser(String userName);
}
