package com.hh99.diary.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiaryRepository extends JpaRepository<com.hh99.diary.domain.Diary, Long> {
    List<com.hh99.diary.domain.Diary> findAllByOrderByModifiedAtDesc();
}