package com.example.todolisttest.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TodoUpdateDto {
    private Long id;
    @NotBlank(message = "할 일 내용을 입력해 주세요.")
    private String title;
}
