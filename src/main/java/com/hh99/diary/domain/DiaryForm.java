package com.hh99.diary.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@NoArgsConstructor
public class DiaryForm {
    private Long id;

    private String title;
    private String username;

    private String contents;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}