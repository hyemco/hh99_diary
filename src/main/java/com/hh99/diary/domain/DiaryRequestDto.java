package com.hh99.diary.domain;

import lombok.Getter;

@Getter
public class DiaryRequestDto {
    private String username;
    private String title;
    private String contents;
}
