package com.example.korea_sleepTech_test_0516.service.implement;

import com.example.korea_sleepTech_test_0516.common.ResponseMessage;
import com.example.korea_sleepTech_test_0516.dto.responseDto.ResponseDto;
import com.example.korea_sleepTech_test_0516.dto.responseDto.UserDetailResDto;
import com.example.korea_sleepTech_test_0516.entity.User;
import com.example.korea_sleepTech_test_0516.repository.UserRepository;
import com.example.korea_sleepTech_test_0516.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public ResponseDto<UserDetailResDto> getUser(String userName) {
        UserDetailResDto data = null;

        User user = userRepository.findByUsername(userName)
                .orElse(null);

        if (user == null) {
            return ResponseDto.setFailed(ResponseMessage.NOT_EXISTS_USER);
        }

        data = UserDetailResDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .role(user.getRole())
                .build();

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }
}
