package com.hh99.diary.service;

import com.hh99.diary.domain.Diary;
import com.hh99.diary.domain.DiaryForm;
import com.hh99.diary.domain.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class DiaryService {
    private final DiaryRepository diaryRepository;

    @Transactional
    public Diary update(Long id, DiaryForm diaryForm) {
        Diary diary = diaryRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("일지가 존재하지 않습니다.")
        );
        diary.update(diaryForm);
        return diary;
    }
}