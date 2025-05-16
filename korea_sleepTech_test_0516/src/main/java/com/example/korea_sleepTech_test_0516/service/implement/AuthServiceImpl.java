package com.example.korea_sleepTech_test_0516.service.implement;

import com.example.korea_sleepTech_test_0516.common.ResponseMessage;
import com.example.korea_sleepTech_test_0516.dto.requestDto.UserLogInReqDto;
import com.example.korea_sleepTech_test_0516.dto.requestDto.UserSignUpReqDto;
import com.example.korea_sleepTech_test_0516.dto.responseDto.ResponseDto;
import com.example.korea_sleepTech_test_0516.dto.responseDto.UserLogInResDto;
import com.example.korea_sleepTech_test_0516.dto.responseDto.UserSignUpResDto;
import com.example.korea_sleepTech_test_0516.entity.User;
import com.example.korea_sleepTech_test_0516.provider.JwtProvider;
import com.example.korea_sleepTech_test_0516.repository.UserRepository;
import com.example.korea_sleepTech_test_0516.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtProvider jwtProvider;

    // 1) 회원 가입
    @Override
    public ResponseDto<UserSignUpResDto> signup(UserSignUpReqDto dto) {
        String username = dto.getUsername();
        String password = dto.getPassword();
        String confirmPassword = dto.getConfirmPassword();
        String role = dto.getRole();

        UserSignUpResDto data = null;
        User user = null;

        // 패스워드 일치 여부 확인
        if (!password.equals(confirmPassword)) {
            // 일치하지 않은 경우
            return ResponseDto.setFailed(ResponseMessage.NOT_MATCH_PASSWORD);
        }

        // 중복되는 이메일 검증
        if (userRepository.existsByUsername(username)) {
            // 중복 되는 경우 (사용할 수 X)
            return ResponseDto.setFailed(ResponseMessage.EXIST_DATA);
        }
//
//        if (!role.equals("ADMIN")) {
//            return ResponseDto.setFailed("ROLE IS NOT MATCH");
//        }
//
//        if (!role.equals("USER")) {
//            return ResponseDto.setFailed("ROLE IS NOT MATCH");
//        }

        // 패스워드 암호화
        String encodePassword = bCryptPasswordEncoder.encode(password);

        user = User.builder()
                .username(username)
                .password(encodePassword)
                .role(role)
                .build();

        userRepository.save(user);

        data = new UserSignUpResDto(user);
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    // 2) 로그인
    @Override
    @Transactional(readOnly = true)
    public ResponseDto<UserLogInResDto> login(UserLogInReqDto dto) {
        String username = dto.getUsername();
        String password = dto.getPassword();

        UserLogInResDto data = null;
        User user = null;

        int exprTime = jwtProvider.getExpiration();

        user = userRepository.findByUsername(username)
                .orElse(null);

        if (user == null) {
            return ResponseDto.setFailed(ResponseMessage.NOT_EXISTS_USER);
        }

        if (!bCryptPasswordEncoder.matches(password, user.getPassword())) {
            // .matches(평문 비밀번호, 암호화된 비밀번호)
            // : 평문 비밀번호(실제 비밀번호)와 암호화된 비밀번호를 비교하여 일치 여부 반환(boolean)
            return ResponseDto.setFailed(ResponseMessage.NOT_MATCH_PASSWORD);
        }

        // 사용자 정보의 권한 정보를 호출
        String role = user.getRole();

        String token = jwtProvider.generateJwtToken(username, role);

        data = new UserLogInResDto(token, user, exprTime);
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }
}