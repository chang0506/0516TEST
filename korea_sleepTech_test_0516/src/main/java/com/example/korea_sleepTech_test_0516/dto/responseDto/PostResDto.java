package com.example.korea_sleepTech_test_0516.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class PostResDto {
    private Long id;
    private String title;
    private String content;
    private Long authorId;

    public static class Builder {
        private Long id;
        private Long authorId;

        // 필수 매개변수
        private final String title;
        private final String content;

        public Builder(String title, String content) {
            this.title = title;
            this.content = content;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder authorId(Long authorId) {
            this.authorId = authorId;
            return this;
        }

        public PostResDto build() {
            return new PostResDto(id, title, content, authorId);
        }
    }
}