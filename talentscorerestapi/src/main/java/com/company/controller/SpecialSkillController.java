package com.company.controller;

import com.company.dto.ResponseDTO;
import com.company.dto.commonDTO.CommonSpecialSkillsDTO;
import com.company.dto.entityDTO.*;
import com.company.entity.*;
import com.company.inter.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequiredArgsConstructor
public class SpecialSkillController {
    @Autowired
    private SpecialSkillQuestionRepository specialSkillsQuestionsRepository;
    @Autowired
    private SpecialSkillAnswerRepository specialSkillsAnswersRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SpecialSkillUserRepository specialSkillUserRepository;

    @GetMapping("/xususi-bacariqlar/xususi-bacariqlar-substage")
    public ResponseEntity<ResponseDTO> additionalLanguages() {
        List<SpecialSkillQuestion> specialSkillsQuestions = specialSkillsQuestionsRepository.findAll();
        List<SpecialSkillAnswer> specialSkillsAnswers = specialSkillsAnswersRepository.findAll();

        List<SpecialSkillsQuestionDTO> specialSkillsQuestionDTOS = new ArrayList<>();
        List<SpecialSkillsAnswerDTO> specialSkillsAnswerDTOS = new ArrayList<>();

        for (SpecialSkillQuestion u : specialSkillsQuestions) {
            specialSkillsQuestionDTOS.add(new SpecialSkillsQuestionDTO(u));
        }
        for (SpecialSkillAnswer u : specialSkillsAnswers) {
            specialSkillsAnswerDTOS.add(new SpecialSkillsAnswerDTO(u));
        }


        List specialSkillsHasList = new ArrayList();
        specialSkillsHasList.add(specialSkillsQuestionDTOS.get(0));
        specialSkillsHasList.add(specialSkillsAnswerDTOS.get(0));
        specialSkillsHasList.add(specialSkillsAnswerDTOS.get(1));

        List specialSkillsList = new ArrayList();
        specialSkillsList.add(specialSkillsQuestionDTOS.get(1));
        specialSkillsList.add(specialSkillsAnswerDTOS.get(2));
        specialSkillsList.add(specialSkillsAnswerDTOS.get(3));
        specialSkillsList.add(specialSkillsAnswerDTOS.get(4));
        specialSkillsList.add(specialSkillsAnswerDTOS.get(5));

        List specialSkillsLevelList = new ArrayList();
        specialSkillsLevelList.add(specialSkillsQuestionDTOS.get(2));
        specialSkillsLevelList.add(specialSkillsAnswerDTOS.get(6));
        specialSkillsLevelList.add(specialSkillsAnswerDTOS.get(7));

        CommonSpecialSkillsDTO commonSpecialSkillsDTO = new CommonSpecialSkillsDTO(specialSkillsHasList, specialSkillsList, specialSkillsLevelList);
        return ResponseEntity.ok(ResponseDTO.of(commonSpecialSkillsDTO));
    }

    @Transactional
    @PostMapping("/xususi-bacariqlar/xususi-bacariqlar-substage")
    public String tehsil(@RequestParam Integer userId,
                         @RequestParam Integer specialSkillQuestionId,
                         @RequestParam Integer specialSkillAnswerId,
                         @RequestParam Integer whichSpecialSkillQuestionId,
                         @RequestParam Integer whichSpecialSkillAnswerId,
                         @RequestParam Integer specialSkillLevelQuestionId,
                         @RequestParam Integer specialSkillLevelAnswerId) {
        User user = userRepository.findById(userId).get();
        if (user != null) {

            SpecialSkillUser userSpecialSkill = new SpecialSkillUser();
            SpecialSkillUser userWhichSpecialSkill = new SpecialSkillUser();
            SpecialSkillUser userSpecialSkillLevel = new SpecialSkillUser();

            List<SpecialSkillUser> specialSkillUserList = new ArrayList<>();
            if (specialSkillAnswerId != null && specialSkillAnswerId != 0) {
                SpecialSkillAnswer specialSkillAnswer = specialSkillsAnswersRepository.findById(specialSkillAnswerId).get();
                userSpecialSkill.setSpecialSkillAnswerId(specialSkillAnswer);
            }
            if (specialSkillQuestionId != null && specialSkillQuestionId != 0) {
                SpecialSkillQuestion specialSkillQuestion = specialSkillsQuestionsRepository.findById(specialSkillQuestionId).get();
                if (specialSkillAnswerId != null && specialSkillAnswerId != 0) {
                    userSpecialSkill.setUserId(user);
                    userSpecialSkill.setSpecialSkillQuestionId(specialSkillQuestion);
                    specialSkillUserList.add(userSpecialSkill);
                }
            }
            if (whichSpecialSkillAnswerId != null && whichSpecialSkillAnswerId != 0) {
                SpecialSkillAnswer whichSpecialSkillAnswer = specialSkillsAnswersRepository.findById(whichSpecialSkillAnswerId).get();
                userWhichSpecialSkill.setSpecialSkillAnswerId(whichSpecialSkillAnswer);
            }

            if (whichSpecialSkillQuestionId != null && whichSpecialSkillQuestionId != 0) {
                SpecialSkillQuestion whichSpecialSkillQuestion = specialSkillsQuestionsRepository.findById(whichSpecialSkillQuestionId).get();
                if (whichSpecialSkillAnswerId != null && whichSpecialSkillAnswerId != 0) {
                    userWhichSpecialSkill.setUserId(user);
                    userWhichSpecialSkill.setSpecialSkillQuestionId(whichSpecialSkillQuestion);
                    specialSkillUserList.add(userWhichSpecialSkill);
                }
            }
            if (specialSkillLevelAnswerId != null && specialSkillLevelAnswerId != 0) {
                SpecialSkillAnswer specialSkillLevelAnswer = specialSkillsAnswersRepository.findById(specialSkillLevelAnswerId).get();
                userSpecialSkillLevel.setSpecialSkillAnswerId(specialSkillLevelAnswer);
            }
            if (specialSkillLevelQuestionId != null && specialSkillLevelQuestionId != 0) {
                SpecialSkillQuestion specialSkillLevelQuestion = specialSkillsQuestionsRepository.findById(specialSkillLevelQuestionId).get();
                userSpecialSkillLevel.setUserId(user);
                userSpecialSkillLevel.setSpecialSkillQuestionId(specialSkillLevelQuestion);
                specialSkillUserList.add(userSpecialSkillLevel);
            }
            specialSkillUserRepository.saveAll(specialSkillUserList);
        }
        return "umumi-suallar";
    }
}
