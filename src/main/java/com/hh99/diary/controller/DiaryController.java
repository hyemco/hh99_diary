package com.hh99.diary.controller;

import com.hh99.diary.domain.Diary;
import com.hh99.diary.domain.DiaryForm;
import com.hh99.diary.domain.DiaryRepository;
import com.hh99.diary.service.DiaryService;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class DiaryController {
    private final DiaryRepository diaryRepository;
    private final DiaryService diaryService;

    // 홈 화면 띄우기
    @GetMapping("/")
    public String home() {
        return "diaries/home";
    }

    // 일지 등록 화면 띄우기
    @GetMapping("/diary/new")
    public String saveDiary(Model model) {
        model.addAttribute(new DiaryForm());
        return "diaries/saveDiaryFrom";
    }

    // 일지 저장하기
    @PostMapping("/api/diaries")
    public String saveDiary(@ModelAttribute DiaryForm diaryForm){
        Diary diary = new Diary(diaryForm);
        diaryRepository.save(diary);
        return "redirect:/";
    }

    // 일지 전체 조회하기
    @GetMapping("/api/diaries")
    @ResponseBody
    public List<Diary> getDiary() {
        return diaryRepository.findAllByOrderByModifiedAtDesc();
    }

    // 일지 상세보기
    @GetMapping("/api/diaries/{id}")
    public String readDiary(@PathVariable Long id, Model model) {
        Optional<Diary> diary = diaryRepository.findById(id);
        model.addAttribute("diary", diary.get());
        return "diaries/readDiaryForm";
    }

    // 일지 수정하기
    @ResponseBody
    @PutMapping("/api/diaries/{id}")
    public Long updateDiary(@PathVariable Long id, @RequestBody DiaryForm diaryForm) {
        diaryService.update(id, diaryForm);
        return id;
    }

    // 일지 삭제하기기
    @ResponseBody
    @DeleteMapping("/api/diaries/{id}")
    public Long deleteDiary(@PathVariable Long id) {
        diaryRepository.deleteById(id);
        return id;
    }
}