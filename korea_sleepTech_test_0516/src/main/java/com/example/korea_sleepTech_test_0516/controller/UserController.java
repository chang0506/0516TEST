package com.example.korea_sleepTech_test_0516.controller;

import com.example.korea_sleepTech_test_0516.common.ApiMappingPattern;
import com.example.korea_sleepTech_test_0516.dto.responseDto.ResponseDto;
import com.example.korea_sleepTech_test_0516.dto.responseDto.UserDetailResDto;
import com.example.korea_sleepTech_test_0516.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @ResponseBody + @Controller
@RequestMapping(ApiMappingPattern.USER_API)
@RequiredArgsConstructor // 생성자 주입
public class UserController {
    private static final String GET_USER_INFO = "/me";

    private final UserService userService;

    @PreAuthorize("hasRole('USER')")
    @GetMapping(GET_USER_INFO)
    public ResponseEntity<ResponseDto<UserDetailResDto>> getUser(@AuthenticationPrincipal String userName){
        ResponseDto<UserDetailResDto> user = userService.getUser(userName);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
