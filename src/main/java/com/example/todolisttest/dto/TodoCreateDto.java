package com.example.todolisttest.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class TodoCreateDto {
    @NotBlank(message = "할 일 내용을 입력해 주세요.")
    private String title;
}