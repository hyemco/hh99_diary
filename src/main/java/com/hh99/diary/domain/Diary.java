package com.hh99.diary.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor // 기본 생성자 자동 생성
@Getter
@Setter
@Entity
public class Diary extends Timestamped { // 생성,수정 시간을 자동으로 만들어줌
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    public Diary(String title, String username, String contents) {
        this.title = title;
        this.username = username;
        this.contents = contents;
    }

    public Diary(DiaryForm diaryForm) {
        this.title = diaryForm.getTitle();
        this.username = diaryForm.getUsername();
        this.contents = diaryForm.getContents();
    }

    public Diary(DiaryRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

    public void update(DiaryRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

}