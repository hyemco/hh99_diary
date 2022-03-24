package com.hh99.diary.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor // 기본 생성자 자동 생성
@Getter
@Setter
@Entity
public class Diary extends com.hh99.diary.domain.Timestamped { // 생성,수정 시간을 자동으로 만들어줌
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

    public Diary(com.hh99.diary.domain.DiaryForm diaryForm) {
        this.title = diaryForm.getTitle();
        this.username = diaryForm.getUsername();
        this.contents = diaryForm.getContents();
    }

    public void update(com.hh99.diary.domain.DiaryForm diaryForm) {
        this.title = diaryForm.getTitle();
        this.username = diaryForm.getUsername();
        this.contents = diaryForm.getContents();
    }

}