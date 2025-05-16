package com.example.korea_sleepTech_test_0516.service;

import com.example.korea_sleepTech_test_0516.dto.requestDto.NoticeCreateReqDto;
import com.example.korea_sleepTech_test_0516.dto.responseDto.NoticeResDto;
import com.example.korea_sleepTech_test_0516.dto.responseDto.ResponseDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public interface NoticeService {
    ResponseDto<NoticeResDto> createNotice(String userName, @Valid NoticeCreateReqDto dto);
}
