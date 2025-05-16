package com.example.korea_sleepTech_test_0516.controller;

import com.example.korea_sleepTech_test_0516.common.ApiMappingPattern;
import com.example.korea_sleepTech_test_0516.dto.requestDto.NoticeCreateReqDto;
import com.example.korea_sleepTech_test_0516.dto.responseDto.NoticeResDto;
import com.example.korea_sleepTech_test_0516.dto.responseDto.PostDetailResDto;
import com.example.korea_sleepTech_test_0516.dto.responseDto.ResponseDto;
import com.example.korea_sleepTech_test_0516.service.NoticeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @ResponseBody + @Controller
@RequestMapping(ApiMappingPattern.NOTICE_API)
@RequiredArgsConstructor // 생성자 주입
public class NoticesController {
    private final NoticeService noticeService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ResponseDto<NoticeResDto>> createNotice(@AuthenticationPrincipal String userName, @Valid @RequestBody NoticeCreateReqDto dto) {
        ResponseDto<NoticeResDto> notice = noticeService.createNotice(userName, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(notice);
    }


}
