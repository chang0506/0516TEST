package com.example.korea_sleepTech_test_0516.dto.responseDto;

import com.example.korea_sleepTech_test_0516.entity.User;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserLogInResDto {
    private String token;
    private User user;
    private int exprTime;
}
