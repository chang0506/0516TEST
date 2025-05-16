package com.example.korea_sleepTech_test_0516.service.implement;

import com.example.korea_sleepTech_test_0516.common.ResponseMessage;
import com.example.korea_sleepTech_test_0516.dto.requestDto.NoticeCreateReqDto;
import com.example.korea_sleepTech_test_0516.dto.responseDto.NoticeResDto;
import com.example.korea_sleepTech_test_0516.dto.responseDto.ResponseDto;
import com.example.korea_sleepTech_test_0516.entity.Notice;
import com.example.korea_sleepTech_test_0516.entity.User;
import com.example.korea_sleepTech_test_0516.repository.NoticeRepository;
import com.example.korea_sleepTech_test_0516.repository.UserRepository;
import com.example.korea_sleepTech_test_0516.service.NoticeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NoticesServiceImpl implements NoticeService {
    private final NoticeRepository noticeRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseDto<NoticeResDto> createNotice(String userName, NoticeCreateReqDto dto) {
        NoticeResDto responseDto = null;
        User user = userRepository.findByUsername(userName)
                .orElse(null);

        if (user == null) {
            return ResponseDto.setFailed(ResponseMessage.NOT_EXISTS_USER);
        }

        Notice newNotice = Notice.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .admin(user)
                .build();

        Notice saved = noticeRepository.save(newNotice);

        responseDto = NoticeResDto.builder()
                .id(saved.getId())
                .title(saved.getTitle())
                .content(saved.getContent())
                .build();

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, responseDto);
    }
}
